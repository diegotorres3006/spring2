package com.fundamentosplatzi.springboot.fundamentos2.configuration;

import com.fundamentosplatzi.springboot.fundamentos2.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos2.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springboot.fundamentos2.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:connection.properties")
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;

    @Value("${value.random}")
    private String random;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Bean
    public MyBeanWithProperties function(){

        return new MyBeanWithPropertiesImplement(name, apellido);
    }

    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder.create()
                .driverClassName(driver)
                .url(jdbcUrl)
                .username(username)
                .password(password)
                .build();
    }
//    public DataSource dataSource(){
//        DataSourceBuilder dataSourceBuilder =DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url("jdbc:h2:mem:testdb");
//        dataSourceBuilder.username("SA");
//        dataSourceBuilder.password("");
//
//        return dataSourceBuilder.build();
//
//    }
}
