package com.rentpal.accounts;

import com.rentpal.accounts.common.DTOModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.rentpal.accounts.filters"})
@EnableEurekaClient
@Configuration
@EnableTransactionManagement
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

    /**
     * Generates DTOModelMapper object that converts domain object to Data Transfer Object and vice versa.
     *
     * @return the DTO model mapper
     */
    @Bean
    public DTOModelMapper dtoModelMapper() {
        return new DTOModelMapper();
    }
}
