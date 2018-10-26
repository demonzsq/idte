package com.zsq.dao;

import com.zsq.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userMapper")
public interface UserMapper {

//    @Delete("")
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUserlistAll();

    List<User>  selectUserByLike(User user);
}