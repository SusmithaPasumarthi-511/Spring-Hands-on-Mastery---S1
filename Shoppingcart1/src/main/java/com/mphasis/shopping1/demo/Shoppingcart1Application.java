package com.mphasis.shopping1.demo;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Shoppingcart1Application {
	 public static void main(String[] args) {
	     ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext1.xml");

	     String[] beanNames = context.getBeanDefinitionNames();
	     for (String beanName : beanNames) {
	         System.out.println(beanName);
	     }
	 }
}