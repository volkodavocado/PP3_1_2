package ru.javamentor.PP3_1_2.service;


import ru.javamentor.PP3_1_2.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void save(User user);

    void removeById(long id);

    User getById(long id);

    void update(User user, long id);
}
