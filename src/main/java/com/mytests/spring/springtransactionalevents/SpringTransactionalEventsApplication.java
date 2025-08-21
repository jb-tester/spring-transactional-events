package com.mytests.spring.springtransactionalevents;

import com.mytests.spring.springtransactionalevents.model.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringTransactionalEventsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringTransactionalEventsApplication.class, args);
    }
    @Bean
        public CommandLineRunner commandLineRunner(PersonService personService) {
            return args -> {
               personService.populateDB();
            };
        }
}
