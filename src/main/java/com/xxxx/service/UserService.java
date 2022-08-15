package com.xxxx.service;

import com.xxxx.service.pojo.User;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
        users.add(new User(1, "sb", "asd123", "dog", "", ""));
        users.add(new User(2, "test", "123456", "test", "", ""));
    }

    public void addUser(User user) {
        if (null == user) {
            throw new RuntimeException("对象为空");
        }
        if (StringUtils.isBlank(user.getUserName())) {
            throw new RuntimeException("对象姓名为空");

        }
        if (StringUtils.isBlank(user.getUserPwd())){
            throw new RuntimeException("对象密码为空");
        }
        for (User temp : users) {
            if(temp.getUserName().equals(user.getUserName())){
                throw  new RuntimeException("用户名已存在!");
            }
        }
        if(users.contains(user)){
            throw  new RuntimeException("用户名已存在!");
        }
        users.add(user);
    }
}
