package ru.rgordeev.rqueue.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rgordeev.rqueue.model.UserDto;
import ru.rgordeev.rqueue.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final RabbitTemplate rabbitTemplate;
    private final UserRepository userRepository;

    public UserServiceImpl(RabbitTemplate rabbitTemplate, UserRepository userRepository) {
        this.rabbitTemplate = rabbitTemplate;
        this.userRepository = userRepository;
    }

    public void sendMessage() {
        userRepository.findAll().forEach(u -> {
            UserDto userDto = new UserDto();
            userDto.setId(u.getId());
            userDto.setLogin(u.getLogin());
            userDto.setPassword(u.getPassword());
            rabbitTemplate.convertAndSend("my_topic_exchange", "my_topic_queue", userDto);
        });
    }
}
