package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @author： lxh
 * @description：
 * @created: 15:38 2018/1/31
 * @modified by:
 */
public interface UserService {

    public User find(Long id);

    public List<User> findALl(List<Long> ids);
}
