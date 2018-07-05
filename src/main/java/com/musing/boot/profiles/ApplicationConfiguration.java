package com.musing.boot.profiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfiguration {
	
	@Bean
	@Profile("prod")
	public MyJavaMessage getMyMessage(@Value("${myprop.myValue}") String value, @Value("${myprop.myInt}") Integer number) {
		MyJavaMessage myMessage = new MyJavaMessage();
		myMessage.setMyValue(value);
		myMessage.setMyInt(number);
		System.out.println("*********************** Creating bean for PROD");
		return myMessage;
	}
	
	@Bean
	@Profile("dev")
	public MyJavaMessage getMyMessageDev(@Value("${myprop.myValue}") String value, @Value("${myprop.myInt}") Integer number) {
		MyJavaMessage myMessage = new MyJavaMessage();
		myMessage.setMyValue(value);
		myMessage.setMyInt(number);
		System.out.println("********************** Creating bean for DEV");
		return myMessage;
	}

}
