package com.hp.bsc.testing.jmssender.config;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "config")
@XmlAccessorType(XmlAccessType.FIELD)
public class Config {

	private List<QueueConfig> queueConfig;

	public List<QueueConfig> getQueueConfig() {
		return queueConfig;
	}

	public void setQueueConfig(List<QueueConfig> queueConfig) {
		this.queueConfig = queueConfig;
	}
}
