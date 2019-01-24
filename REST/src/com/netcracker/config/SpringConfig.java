package com.netcracker.config;

import com.netcracker.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@PropertySource(value = {"classpath:app.properties"})
@ComponentScan(basePackages = "com.netcracker")
public class SpringConfig extends WebMvcConfigurerAdapter {

    @Autowired
    Environment enviroment;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(enviroment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(enviroment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(enviroment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(enviroment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
    @Bean
    public Class<Buyer> buyerClassBean(){
        return Buyer.class;
    }


}
