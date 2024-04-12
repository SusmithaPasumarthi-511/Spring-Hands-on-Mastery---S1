package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShoppingcartApplication {
 public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");

     String[] beanNames = context.getBeanDefinitionNames();
     for (String beanName : beanNames) {
         System.out.println(beanName);
     }
 }
	}

