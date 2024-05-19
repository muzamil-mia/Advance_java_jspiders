package com.muzamil.DemoSpring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


public class App {
	public static void main(String[] args) {
		
		// Alien obj = new Alien();
		
		 BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		 Alien obj = (Alien)factory.getBean("alien");
		
	}
}
