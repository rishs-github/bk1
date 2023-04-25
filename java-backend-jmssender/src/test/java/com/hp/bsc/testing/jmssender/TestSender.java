package com.hp.bsc.testing.jmssender;

import com.hp.bsc.testing.jmssender.auth.Authentication;
import com.hp.bsc.testing.jmssender.auth.Authentication_Service;
import com.hp.bsc.testing.jmssender.auth.SecurityObject;
import com.hp.bsc.testing.jmssender.config.Config;
import com.hp.bsc.testing.jmssender.config.QueueConfig;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class TestSender
{

    @Test
    public void generateXml() throws JAXBException
    {
        Config config = new Config();
        QueueConfig hornetQueueConfig = new QueueConfig();
        hornetQueueConfig.setQueueId("sic");

        List<QueueConfig> queueConfig = new ArrayList<QueueConfig>();
        queueConfig.add(hornetQueueConfig);
        config.setQueueConfig(queueConfig);

        Marshaller marshaller = JAXBContext.newInstance(Config.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(config, System.out);
    }

    @Test
    public void testZVAV() throws Exception
    {
        SenderClient.main(new String[]{"UNIFI_EINGANG", "E", "src\\test\\resources\\test.xml"});
    }


//    @Test
    public void testWebService() throws Exception
    {

        URL url = new URL("http://s-zss-wsproxy.rtc.ch:15968/zss_ws/Authentication?wsdl");
        Authentication_Service service = new Authentication_Service(url);
        Authentication port = service.getAuthenticationPort();

        byte[] token = Base64.getDecoder().decode("fEqNCco3Yq9h5ZUglD3CZJT4lBs=");

        SecurityObject securityObject = port.login("RSC05", null, 5, token);

    }
}
