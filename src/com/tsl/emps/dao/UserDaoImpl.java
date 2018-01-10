package com.tsl.emps.dao;


import com.tsl.emps.comon.jdbc.MyDbUtil;
import com.tsl.emps.domain.User;
import com.tsl.emps.domain.Value;

import java.sql.Connection;
import java.util.List;

public class UserDaoImpl  implements UserDao{
    //dao  注入数据源!
    @Override
    public User selectUserByName(String name) {
        Connection conn = MyDbUtil.getConnection();
        String sql = " select  id, name, password,image from user where name = ?" ;
        List<User> list = MyDbUtil.executeQuery(conn,User.class,sql,name);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public User selectUserById(Integer id) {
        Connection conn = MyDbUtil.getConnection();
        String sql = " select  id, name, password,image from user where id = ?" ;
        List<User> list = MyDbUtil.executeQuery(conn,User.class,sql,id);
        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<User> selectUsers() {
        Connection conn = MyDbUtil.getConnection();
        String sql = " select  id, name, password,image from user " ;
        List<User> list = MyDbUtil.executeQuery(conn,User.class,sql);
        return list;
    }

    @Override
    public void insertUser(User user) {
        Connection conn = MyDbUtil.getConnection();
        String sql = " insert into User(name,password,image) values( ?,?,? ) " ;
        MyDbUtil.executeUpdate(conn,sql,user.getName(),user.getPassword(),user.getImage());
    }

    @Override
    public void updateUser(User user) {
        Connection conn = MyDbUtil.getConnection();
        String sql = " update user set name = ? ,password = ? where id = ? " ;
        MyDbUtil.executeUpdate(conn,sql,user.getName(),user.getPassword(),user.getId());
    }

    @Override
    public void deleteUserById(Integer... ids) {
        Connection conn = MyDbUtil.getConnection();
        String sql = " delete from user " ;
        if(ids!=null && ids.length>0){
            sql = sql + " where id in ( ";
            for (int i =0;i<ids.length;i++){
                if(i==ids.length-1){
                    sql = sql+"?";
                }else{
                    sql = sql+"?,";
                }
            }
            sql = sql + " )";
        }
        System.out.println(sql);
        MyDbUtil.executeUpdate(conn,sql,ids);

    }

    @Override
    public int selectUserCount() {
        Connection conn = MyDbUtil.getConnection();
        String sql = "  select  count(*) 'value' from user " ;
        List<Value> list = MyDbUtil.executeQuery(conn,Value.class,sql);
        return (int) list.get(0).getValue();
    }

    public static void main(String[] args) {
        UserDao dao = new UserDaoImpl();
        User u = dao.selectUserById(1);

    //    dao.deleteUserById(8,9);
        /*dao.insertUser(new User("111111","123456"));
        dao.insertUser(new User("222222","123456"));
        dao.insertUser(new User("333333","123456"));*/
        System.out.println(u);
       // dao.deleteUserById(1,2,3);
    }
}
