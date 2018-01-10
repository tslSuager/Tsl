package com.tsl.emps.dao;


import com.tsl.emps.domain.User;

import java.util.List;

public interface UserDao {
    public User selectUserByName(String name);
    public User selectUserById(Integer id);
    public List<User> selectUsers();
    public void  insertUser(User user);
    public void  updateUser(User user);
    public void  deleteUserById(Integer... ids);
    public int  selectUserCount();
}
