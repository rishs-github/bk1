package com.hp.bsc.testing.messageparser;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Messageparser {


    int MAX_MSG = 50;

    String sourceFilePath = "src\\test\\resources\\msgs.txt";
    String execDate = "2019-01-01";
    String initParty = "Berner Kantonalbank AG";

    public String getMsgId() {
        return "MSGID-" + getRandomNumberString(10);
    }

    void parser() {

        try {
            String mesgs = IOUtils.toString(new File(sourceFilePath).toURI(), "UTF-8");
            formatPayments(mesgs);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void formatPayments(String wholeShit) {
        String pmtString = "";
        String pmtReg = "(<PmtInf>.*</PmtInf>)";
        Pattern pmtPattern = Pattern.compile(pmtReg);
        Matcher m = pmtPattern.matcher(wholeShit);
        DecimalFormat df2 = new DecimalFormat("#.##");
        int nb = 0;
        int cnt = 1;
        Double ctrlsum = 0.0;   //TODO bigdecimal

        while (m.find()) {
            nb++;

            String amtRegex = "<InstdAmt Ccy=\"\"?...\"\"?>(.*)?</InstdAmt>";
            Pattern amtPattern = Pattern.compile(amtRegex);

            pmtString = pmtString + m.group(1)
                    .replaceAll("<ReqdExctnDt>(.*)?</ReqdExctnDt>", "<ReqdExctnDt>" + execDate + "</ReqdExctnDt>")
                    .replaceAll("<PmtInfId>(.*)?</PmtInfId>", "<PmtInfId>" + getRandomHexString(10) + "</PmtInfId>")
                    .replaceAll("<InstrId>(.*)?</InstrId>", "<InstrId>" + getRandomHexString(15) + "</InstrId>")
                    .replaceAll("<EndToEndId>(.*)?</EndToEndId>", "<EndToEndId>692504500" + getRandomNumberString(9) + "</EndToEndId>") //692504500+000003259
                    + '\n';

            //count control sum

            Matcher amtMatcher = amtPattern.matcher(m.group(1));
            amtMatcher.find();
            ctrlsum += Double.valueOf(amtMatcher.group(1));

            if (nb >= MAX_MSG) {
                System.out.println("nb of payments: " + nb);
                System.out.println("ctrlsum: " + df2.format(ctrlsum));
                System.out.println("max number reached..");

                pmtString = pmtString.replaceAll("</", "</pain:")
                        .replaceAll("(<[^/])", "<pain:$1")
                        .replaceAll(":<", ":");

                //create message
                StringBuilder sb = new StringBuilder();
                sb.append(Templates.SOAPENV_START)
                  .append(Templates.GRPHDR_TEMPLATE.replaceAll("NUMBER_OF_PAYMENTS", String.valueOf(nb))
                                .replaceAll("CONTROL_SUM", df2.format(ctrlsum))
                                .replaceAll("MESSAGE_ID", getMsgId())
                                .replaceAll("INIT_PARTY", initParty))
                  .append(pmtString)
                  .append(Templates.SOAPENV_END);

                //save to file
                System.out.println("saving to file: " + "group_"+String.valueOf(cnt)+".xml");
                dumpToFile("group_"+String.valueOf(cnt)+".xml", sb.toString());

                cnt++;
                //reset counters
                nb = 0;
                ctrlsum = 0.0;
                pmtString="";
            }

        } //end while

        if (nb > 0) {
            System.out.println("XXX remaining payments..");
            System.out.println("XXX nb of payments: " + nb);
            System.out.println("XXX ctrlsum: " + df2.format(ctrlsum));
            pmtString = pmtString.replaceAll("</", "</pain:")
                    .replaceAll("(<[^/])", "<pain:$1")
                    .replaceAll(":<", ":");

            //create message
            StringBuilder sb = new StringBuilder();
            sb.append(Templates.SOAPENV_START)
                    .append(Templates.GRPHDR_TEMPLATE.replaceAll("NUMBER_OF_PAYMENTS", String.valueOf(nb))
                            .replaceAll("CONTROL_SUM", df2.format(ctrlsum))
                            .replaceAll("MESSAGE_ID", getMsgId())
                            .replaceAll("INIT_PARTY", initParty))
                    .append(pmtString)
                    .append(Templates.SOAPENV_END);

            //save to file
            System.out.println("saving to file: " + "group_"+String.valueOf(cnt)+".xml");
            dumpToFile("group_"+String.valueOf(cnt)+".xml", sb.toString());
        }

    }


    private void dumpToFile(String fName, String content) {
        try (
                FileWriter writer = new FileWriter(fName);
                BufferedWriter bw = new BufferedWriter(writer)) {
                bw.write(content);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    private String getRandomHexString(int numchars) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < numchars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }


    private String getRandomNumberString(int numchars) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < numchars) {
            sb.append(Math.abs((r.nextInt())));
        }
        return sb.toString().substring(0, numchars);
    }


    @Test
    public void testParser() {
        parser();
    }

}