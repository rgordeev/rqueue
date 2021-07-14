package ru.rgordeev.rqueue.consumers;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.rgordeev.rqueue.model.UserDto;

@Component
@Slf4j
public class MessageConsumer {

    @RabbitListener(queues = "my_topic_queue")
    public void consumeMessage(UserDto userDto) {
        log.warn("User: {}", userDto);
    }
}
