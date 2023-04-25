package com.hp.bsc.testing.jmssender.config;

public class LoginConfig {

	private String userName;
	private String password;
	private Integer mandant;
	private String wsdlUrl;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWsdlUrl() {
		return wsdlUrl;
	}

	public void setWsdlUrl(String wsdlUrl) {
		this.wsdlUrl = wsdlUrl;
	}

	public Integer getMandant() {
		return mandant;
	}

	public void setMandant(Integer mandant) {
		this.mandant = mandant;
	}
}
