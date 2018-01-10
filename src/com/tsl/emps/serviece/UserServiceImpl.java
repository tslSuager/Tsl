package com.tsl.emps.serviece;


import com.tsl.emps.dao.UserDao;
import com.tsl.emps.dao.UserDaoImpl;
import com.tsl.emps.domain.User;

public class UserServiceImpl implements UserService {
    //服务层 注入 dao 层
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User findUserByName(String name) {
        return userDao.selectUserByName(name);
    }

    @Override
    public void addUSer(User user) {
         userDao.insertUser(user);
    }

}
