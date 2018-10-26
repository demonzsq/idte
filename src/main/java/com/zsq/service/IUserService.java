package com.zsq.service;

import com.zsq.pojo.User;
import org.springframework.stereotype.Repository;


@Repository("iaserService")
public interface IUserService {

    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
