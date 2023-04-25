package com.hp.bsc.testing.jmssender;

import ch.rtc.infra.bdv.type.InBdv_Zahlungsweg;
import ch.rtc.zvc.services.interfaces.eingang.zvav.type.BuZvc_PacsXmlAuftraege;
import ch.rtc.zvc.services.interfaces.eingang.zvav.type.BuZvc_PacsXmlAuftrag;

import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.lang3.StringUtils;

import com.hp.bsc.testing.jmssender.auth.SecurityObject;
import com.hp.bsc.testing.jmssender.config.QueueEnvironmentConfig;

public class HornetQSender
{
    public static AtomicInteger count = new AtomicInteger(0);

    public static final String JMS_SECURITY_PROPERTY_MANDANT = "jabas_ctx_mandant";

    public static final String JMS_SECURITY_PROPERTY_LOGINNAME = "jabas_ctx_loginName";

    public static final String JMS_SECURITY_PROPERTY_CREDENTIAL = "jabas_ctx_credential";

    public static final String JMS_SECURITY_PROPERTY_TIMESTAMP = "jabas_ctx_timestamp";

    public void send(QueueEnvironmentConfig config, String message, SecurityObject securityObject, String queueName, String zahlungsWeg) throws Exception
    {
        QueueConnection connection = null;
        try
        {
            Properties prop = new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            prop.put(Context.PROVIDER_URL, "remote://" + config.getHornetqUrl());
            Context context = new InitialContext(prop);
            ConnectionFactory connnectionFactory = (ConnectionFactory) context.lookup(config.getHornetqFactoryJndiName());
            connection = (QueueConnection) connnectionFactory.createConnection(config.getHornetqUserName(), config.getHornetqPassword());
            connection.start();

            Session session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = session.createQueue(config.getJndiName());
            MessageProducer producer = session.createProducer(queue);

            Message jmsMessage = null;

            if (queueName.equals("ZVAV_EINGANG"))
            {
                InBdv_Zahlungsweg inBdv_Zahlungsweg = null;
                if (StringUtils.isEmpty(zahlungsWeg))
                {
                    inBdv_Zahlungsweg = InBdv_Zahlungsweg.EINZELAUFTRAG;
                }
                else
                {
                    inBdv_Zahlungsweg = InBdv_Zahlungsweg.createZahlungsweg(zahlungsWeg);
                }

                BuZvc_PacsXmlAuftraege autrage = new BuZvc_PacsXmlAuftraege(new BuZvc_PacsXmlAuftrag(message, inBdv_Zahlungsweg));
                jmsMessage = session.createObjectMessage(autrage);
            }
            else
            {
                jmsMessage = session.createTextMessage(message);
            }

            if (securityObject != null)
            {
                jmsMessage.setIntProperty(JMS_SECURITY_PROPERTY_MANDANT, securityObject.getMandant());
                jmsMessage.setStringProperty(JMS_SECURITY_PROPERTY_LOGINNAME, securityObject.getName());
//                jmsMessage.setStringProperty(JMS_SECURITY_PROPERTY_CREDENTIAL, Base64.getEncoder().encodeToString(securityObject.getToken()));
//                textMessage.setStringProperty(IzuUt_Properties.JMS_SECURITY_PROPERTY_CREDENTIAL, IzuUt_Format.getHexString(securityObject.getToken()));
                jmsMessage.setStringProperty(JMS_SECURITY_PROPERTY_CREDENTIAL, IzuUt_Format.getHexString(securityObject.getToken()));
                jmsMessage.setLongProperty(JMS_SECURITY_PROPERTY_TIMESTAMP, securityObject.getTimestamp().toGregorianCalendar().getTimeInMillis());
            }

            producer.send(jmsMessage);
        }
        finally
        {
            if (connection != null)
            {
                connection.close();
            }
        }

    }
}
