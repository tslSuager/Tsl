package com.tsl.emps.serviece;


import com.tsl.emps.domain.User;

public interface UserService {
    public User findUserByName(String name);

    void addUSer(User user);
}
