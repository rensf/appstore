package com.sys.appstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AppstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppstoreApplication.class, args);
    }

}
