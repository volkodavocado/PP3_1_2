package ru.javamentor.PP3_1_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.PP3_1_2.dao.UserDao;
import ru.javamentor.PP3_1_2.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    //todo: @Transactional(READONLY) ?? нужно разобраться для каких методов
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void removeById(long id) {
        userDao.removeById(id);
    }//todo: long id - переходим на ссылочные (везде ..по всему коду)

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    public void update(User user, long id) {
        userDao.update(user, id);
    }
}
