package cn.project.service.impl;

import cn.project.entity.User;
import cn.project.mapper.UserMapper;
import cn.project.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User getUser(String username) {
        return userMapper.findByUsername(username);
    }
}
