package com.mytests.spring.springtransactionalevents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringTransactionalEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionalEventsApplication.class, args);
    }

}
