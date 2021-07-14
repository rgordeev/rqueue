package ru.rgordeev.rqueue.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rgordeev.rqueue.model.User;
import ru.rgordeev.rqueue.model.UserDto;
import ru.rgordeev.rqueue.repository.UserRepository;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/user", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
        final User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return ResponseEntity.ok(userRepository.save(user));
    }
}
