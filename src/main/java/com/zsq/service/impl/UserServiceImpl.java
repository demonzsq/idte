package com.zsq.service.impl;

import com.zsq.dao.UserMapper;
import com.zsq.pojo.User;
import com.zsq.service.IUserService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer uId) {
        return userMapper.deleteByPrimaryKey(uId);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Integer uId) {
        return userMapper.selectByPrimaryKey(uId);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
}
