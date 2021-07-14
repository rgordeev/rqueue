package ru.rgordeev.rqueue.model;

import java.util.StringJoiner;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {
    private Long id;
    private String login;
    private String password;

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDto.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("login='" + login + "'")
            .add("password='" + password + "'")
            .toString();
    }
}
