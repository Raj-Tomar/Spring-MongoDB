package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mongodb.MongoClient;

@EnableWebMvc
@Configuration
@EnableMongoRepositories(basePackages = "com.raj")
@ComponentScan(basePackages = {"com.raj.app.config", "com.raj"})
public class AppConfig extends WebMvcConfigurerAdapter {
	
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    
    // MongoDB Configuration Start
    @Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		//UserCredentials userCredentials = new UserCredentials("", "");
		//return new SimpleMongoDbFactory(mongoClient, "test", UserCredentials);
		return new SimpleMongoDbFactory(mongoClient, "test");
	}
    
    @Bean
	public MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
    
    // MongoDB Configuration Start
}
