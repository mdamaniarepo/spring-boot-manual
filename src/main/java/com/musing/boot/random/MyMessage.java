package com.musing.boot.random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyMessage {
	
	@Value("${myprop.myValue}")
	private String myValue;
	
	@Value("${myprop.myInt}")
	private Integer myInt;

	public String getMyValue() {
		return myValue;
	}

	public void setMyValue(String myValue) {
		this.myValue = myValue;
	}

	public Integer getMyInt() {
		return myInt;
	}

	public void setMyInt(Integer myInt) {
		this.myInt = myInt;
	}
	
}
