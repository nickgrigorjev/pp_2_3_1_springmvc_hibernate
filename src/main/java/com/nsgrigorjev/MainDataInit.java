package com.nsgrigorjev;

import com.nsgrigorjev.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainDataInit {
    private final UserService userService;

    private static final String INSERT_DATA = "INSERT INTO users (id, name, last_name, age)\n" +
            "VALUES (1,'Николай','Королев',77),\n" +
            "(2,'Мария','Озерова',27),\n" +
            "(3,'Диана','Карпова',60),\n" +
            "(4,'Анна','Лебедева',65),\n" +
            "(5,'Роман','Маслов',15),\n" +
            "(6,'Ксения','Губанова',31),\n" +
            "(7,'Савва','Быков',42),\n" +
            "(8,'Денис','Алексеев',39),\n" +
            "(9,'Платон','Чернов',39),\n" +
            "(10,'Татьяна','Максимова',33);";

    @PostConstruct
    public void init() {
        userService.executeNativeQuery(INSERT_DATA);
    }


}
