package com.hp.bsc.testing.messageparser;

public class Templates {

    public static final String SOAPENV_START = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ch=\"http://ch/rtc/zvc/iso20022/pain/001.03.ch.02\" xmlns:pain=\"http://www.six-interbank-clearing.com/de/pain.001.001.03.ch.02.xsd\"><soapenv:Header/><soapenv:Body><ch:payment><pain:Document><pain:CstmrCdtTrfInitn>";
    public static final String SOAPENV_END = "</pain:CstmrCdtTrfInitn></pain:Document></ch:payment></soapenv:Body></soapenv:Envelope>";
    public static final String GRPHDR_TEMPLATE = "" +
            "<pain:GrpHdr>" +
            "<pain:MsgId>MESSAGE_ID</pain:MsgId>" +     //MESSAGE_ID
            "<pain:CreDtTm>2019-08-02T09:04:41.5017029+02:00</pain:CreDtTm>" +  //CREATION_TIME
            "<pain:NbOfTxs>NUMBER_OF_PAYMENTS</pain:NbOfTxs>" +
            "<pain:CtrlSum>CONTROL_SUM</pain:CtrlSum>" +
            "<pain:InitgPty><pain:Nm>INIT_PARTY</pain:Nm></pain:InitgPty>" + //INIT_PARTY
            "</pain:GrpHdr>";

}
