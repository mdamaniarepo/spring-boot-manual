package com.musing.boot.externalprops;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="ext.props")
public class MyExternalProperties {

	private String myValue;

	public String getMyValue() {
		return myValue;
	}

	public void setMyValue(String myValue) {
		this.myValue = myValue;
	}

}
