package com.hp.bsc.testing.jmssender.config;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class QueueConfig
{

    @XmlAttribute
    private String queueId;

    private List<QueueEnvironmentConfig> queueEnvironmentConfig;

    public String getQueueId()
    {
        return queueId;
    }

    public void setQueueId(String queueId)
    {
        this.queueId = queueId;
    }

    public List<QueueEnvironmentConfig> getQueueEnvironmentConfig()
    {
        return queueEnvironmentConfig;
    }

    public void setQueueEnvironmentConfig(List<QueueEnvironmentConfig> queueEnvironmentConfig)
    {
        this.queueEnvironmentConfig = queueEnvironmentConfig;
    }

}
