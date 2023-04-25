package com.hp.bsc.testing.jmssender;

import com.hp.bsc.testing.jmssender.auth.Authentication;
import com.hp.bsc.testing.jmssender.auth.Authentication_Service;
import com.hp.bsc.testing.jmssender.auth.SecurityObject;
import com.hp.bsc.testing.jmssender.auth.UserNotAuthenticatedException;
import com.hp.bsc.testing.jmssender.config.Config;
import com.hp.bsc.testing.jmssender.config.QueueConfig;
import com.hp.bsc.testing.jmssender.config.QueueEnvironmentConfig;
import org.apache.commons.io.IOUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Base64;

public class SenderClient
{
    public static void main(String[] args) throws Exception
    {
        if (args.length < 3 || args.length > 4)
        {
            System.out.println("Number of parameters is invalid");
            System.out.println("The class should be called with following parameters: <queuename> <environment> <message> (<zahlungsweg>)");
            System.exit(1);
        }
        else
        {
            try
            {
                String queueName = args[0];
                String environment = args[1];
                String filePath = args[2];
                String zahlungsWeg = null;
                if (args.length == 4)
                {
                    zahlungsWeg = args[3];
                }

                String message = IOUtils.toString(new File(filePath).toURI(), "UTF-8");

                Config config = getConfig();
                QueueEnvironmentConfig queueEnvConfig = findQueueEnvConfig(config, queueName, environment);
                SecurityObject securityObject = login(queueEnvConfig);

                if (queueEnvConfig.isHornetQConfig())
                {
                    new HornetQSender().send(queueEnvConfig, message, securityObject, queueName, zahlungsWeg);
                }
                else
                {
                    WmqSender.send(queueEnvConfig, message);
                }

                System.out.println("Message sent successfully");
                System.exit(0);

            }
            catch (Exception e)
            {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    private static SecurityObject login(QueueEnvironmentConfig queueEnvConfig) throws MalformedURLException, UserNotAuthenticatedException
    {
        if (queueEnvConfig.getLoginConfig() != null)
        {
            URL url = new URL(queueEnvConfig.getLoginConfig().getWsdlUrl());
            Authentication_Service service = new Authentication_Service(url);
            Authentication port = service.getAuthenticationPort();
            byte[] token = Base64.getDecoder().decode(queueEnvConfig.getLoginConfig().getPassword());

            return port.login(queueEnvConfig.getLoginConfig().getUserName(), null, queueEnvConfig.getLoginConfig().getMandant(), token);
        }
        else
        {
            return null;
        }
    }

    private static QueueEnvironmentConfig findQueueEnvConfig(Config config, String queueName, String environment) throws JAXBException, URISyntaxException
    {
        for (QueueConfig queueConfig : config.getQueueConfig())
        {
            if (queueName.equalsIgnoreCase(queueConfig.getQueueId()))
            {
                for (QueueEnvironmentConfig queueEnvConfig : queueConfig.getQueueEnvironmentConfig())
                {
                    if (environment.equalsIgnoreCase(queueEnvConfig.getEnvironment()))
                    {
                        return queueEnvConfig;
                    }
                }
            }
        }

        throw new IllegalArgumentException(String.format("For queue: %s and env: %s the configuration was not found", queueName, environment));
    }

    private static Config getConfig() throws JAXBException, URISyntaxException
    {
        Unmarshaller unmarshaller = JAXBContext.newInstance(Config.class).createUnmarshaller();

        File base = new File(SenderClient.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
        File configFile = new File(base, "com.hp.bsc.testing.jmssender-config.xml");

        return (Config) unmarshaller.unmarshal(configFile);
    }
}
