package com.example.question;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.question.configuration.MyConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(MyConfiguration.class)
public class QuestionJdbcApplication implements CommandLineRunner{
 
	private final MyConfiguration configuration;
	 public QuestionJdbcApplication(MyConfiguration configuration) {
		    this.configuration = configuration;
		  }
	public static void main(String[] args) {
		SpringApplication.run(QuestionJdbcApplication.class, args);
	}

	 public void run(String... args) {

		    Logger logger = LoggerFactory.getLogger(QuestionJdbcApplication.class);

		    logger.info("----------------------------------------");
		    logger.info("Configuration properties");
		    logger.info("   example.username is {}", configuration.getUsername());
		    logger.info("   example.password is {}", configuration.getPassword());
		    logger.info("----------------------------------------");
		  }
	

}
