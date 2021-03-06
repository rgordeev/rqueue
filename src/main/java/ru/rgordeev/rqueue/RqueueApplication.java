package ru.rgordeev.rqueue;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableRabbit
public class RqueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(RqueueApplication.class, args);
    }

}
