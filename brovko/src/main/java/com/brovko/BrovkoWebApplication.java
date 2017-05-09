package com.brovko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@ServletComponentScan
@EnableJpaRepositories
@EnableAspectJAutoProxy
public class BrovkoWebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BrovkoWebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        //System.setProperty("spring.devtools.restart.enabled", "false");  //Prevent automatically restart whenever files on the classpath change.
        SpringApplication.run(BrovkoWebApplication.class, args);
    }
}
