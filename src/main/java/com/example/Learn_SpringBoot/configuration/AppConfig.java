package com.example.Learn_SpringBoot.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.Learn_SpringBoot.DB;
import com.example.Learn_SpringBoot.DevDB;
import com.example.Learn_SpringBoot.ProdDB;

@Configuration
public class AppConfig {

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    public DB getProdDBBean() {
        return new ProdDB();
    }

    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public DB getDevDBBean() {
        return new DevDB();
    }
}
