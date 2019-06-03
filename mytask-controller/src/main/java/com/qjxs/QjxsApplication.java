package com.qjxs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.qjxs.filter.AuthorizationFilterProperties;

@SpringBootApplication
//@Configuration
//@EnableTransactionManagement(proxyTargetClass = true)
@EntityScan("com.qjxs.domain")
@ComponentScan(basePackages ="com.qjxs")
@EnableJpaRepositories("com.qjxs.repository")
@EnableConfigurationProperties(AuthorizationFilterProperties.class)
@ServletComponentScan
//@EnableAutoConfiguration
public class QjxsApplication {
    public static void main(String[] args) {
        SpringApplication.run(QjxsApplication.class, args);
    }
}
