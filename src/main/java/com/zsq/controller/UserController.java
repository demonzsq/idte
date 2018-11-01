package com.zsq.controller;

import com.alibaba.fastjson.JSON;
import com.zsq.pojo.SysUser;
import com.zsq.redis.RedisChahe;
import com.zsq.service.SysUserServiceI;
import com.zsq.util.AvoidDuplicateSubmission;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    Logger logger = LogManager.getLogger();
    @Resource
    private SysUserServiceI sysUserServiceI;

    @Resource
    private RedisChahe redisChahe;

    @RequestMapping(value = "/login")
    public String Login(){
        System.out.println("测试成功");
        SysUser sysUser = sysUserServiceI.selectByPrimaryKey(1);
        System.out.println("sysUser:---"+sysUser);

        return "success.jsp";
    }





}