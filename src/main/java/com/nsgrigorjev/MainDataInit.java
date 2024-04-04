package com.nsgrigorjev;

import com.nsgrigorjev.database.entity.User;
import com.nsgrigorjev.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
@RequiredArgsConstructor
public class MainDataInit {
    private final UserService userService;

    @PostConstruct
    public void init() {
        userService.persist(new User("Nick", "Grigorjev", (byte)32));
        userService.persist(new User("Mari", "Grigorjeva", (byte)22));
        userService.persist(new User("Semen", "Pavlov", (byte)45));
    }
}
