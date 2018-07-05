package com.musing.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.musing.boot.externalprops.MyCustomProperties;
import com.musing.boot.externalprops.MyExternalProperties;
import com.musing.boot.profiles.MyJavaMessage;
import com.musing.boot.random.MyMessage;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(value=MyExternalProperties.class)
public class Application {
	
	@Value("${name}")
	private String name;
	
	@Autowired
	private MyMessage myMessage;
	
	@Autowired
	private MyJavaMessage myJavaMessage;
	
	@Autowired
	private MyExternalProperties myExternalProperties;
	
	@Autowired
	private MyCustomProperties myCustomProperties;
	
	@RequestMapping("/random")
	public String random() {
		return myMessage.getMyValue() + " : " + myMessage.getMyInt();
	}
	
	@RequestMapping("/profiles")
	public String profilesTest() {
		return myJavaMessage.getMyValue() + " : " + myJavaMessage.getMyInt();
	}
	
	@RequestMapping("/ext")
	public String externalProps() {
		return myExternalProperties.getMyValue();
	}
	
	@RequestMapping("/customprops")
	public String customProps() {
		return myCustomProperties.getMyValue();
	}
	
	@RequestMapping("/")
	public String home() {
		return name;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyMessage getMyMessage() {
		return myMessage;
	}

	public void setMyMessage(MyMessage myMessage) {
		this.myMessage = myMessage;
	}
	
	

}
