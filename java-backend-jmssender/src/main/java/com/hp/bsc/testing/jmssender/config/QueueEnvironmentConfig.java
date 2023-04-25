package com.hp.bsc.testing.jmssender.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "queueEnvironmentConfig")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueueEnvironmentConfig {

	@XmlAttribute
	private String environment;
	private String jndiName;

	// hornetq specific
	private String hornetqUrl;
	private String hornetqFactoryJndiName;
	private String hornetqUserName;
	private String hornetqPassword;

	// wmq specific
	private String wmqHost;
	private Integer wmqPort;
	private String wmqManagerName;
	private String wmqChannel;

	private LoginConfig loginConfig;

	public boolean isHornetQConfig() {
		return hornetqUrl != null;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getJndiName() {
		return jndiName;
	}

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	public String getHornetqUrl() {
		return hornetqUrl;
	}

	public void setHornetqUrl(String hornetqUrl) {
		this.hornetqUrl = hornetqUrl;
	}

	public String getHornetqFactoryJndiName() {
		return hornetqFactoryJndiName;
	}

	public void setHornetqFactoryJndiName(String hornetqFactoryJndiName) {
		this.hornetqFactoryJndiName = hornetqFactoryJndiName;
	}

	public String getHornetqUserName() {
		return hornetqUserName;
	}

	public void setHornetqUserName(String hornetqUserName) {
		this.hornetqUserName = hornetqUserName;
	}

	public String getHornetqPassword() {
		return hornetqPassword;
	}

	public void setHornetqPassword(String hornetqPassword) {
		this.hornetqPassword = hornetqPassword;
	}

	public String getWmqHost() {
		return wmqHost;
	}

	public void setWmqHost(String wmqHost) {
		this.wmqHost = wmqHost;
	}

	public Integer getWmqPort() {
		return wmqPort;
	}

	public void setWmqPort(Integer wmqPort) {
		this.wmqPort = wmqPort;
	}

	public String getWmqManagerName() {
		return wmqManagerName;
	}

	public void setWmqManagerName(String wmqManagerName) {
		this.wmqManagerName = wmqManagerName;
	}

	public String getWmqChannel() {
		return wmqChannel;
	}

	public void setWmqChannel(String wmqChannel) {
		this.wmqChannel = wmqChannel;
	}

	public LoginConfig getLoginConfig() {
		return loginConfig;
	}

	public void setLoginConfig(LoginConfig loginConfig) {
		this.loginConfig = loginConfig;
	}

}
