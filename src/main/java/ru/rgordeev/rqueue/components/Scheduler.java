package ru.rgordeev.rqueue.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.rgordeev.rqueue.service.UserService;

@Component
@Slf4j
public class Scheduler {
    public final UserService userService;

    public Scheduler(UserService userService) {
        this.userService = userService;
    }

    @Scheduled(fixedDelay = 2000)
    public void send() {
        log.info("Scheduled message");
        userService.sendMessage();
    }
}
