package ru.javamentor.PP3_1_2.dao;


import ru.javamentor.PP3_1_2.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    void save(User user);

    void removeById(Long id);

    User getById(Long id);

    void update(User user, Long id);
}
