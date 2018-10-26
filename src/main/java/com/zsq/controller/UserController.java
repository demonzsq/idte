package com.zsq.controller;

import com.alibaba.fastjson.JSON;
import com.zsq.dao.UserMapper;
import com.zsq.pojo.User;
import com.zsq.redis.RedisChahe;
import com.zsq.service.IUserService;
import com.zsq.service.impl.UserServiceImpl;
import com.zsq.util.AvoidDuplicateSubmission;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    Logger logger = LogManager.getLogger();
    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisChahe redisChahe;



    @RequestMapping(value = "/selectAll")
    public String select(Model model,User user){
        System.out.println("成功");

        List<User> users = userMapper.selectUserByLike(user);

        logger.info(users);
        model.addAttribute("user",users);

        return "success.jsp";
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(Model model,User user){

        userMapper.insert(user);
        System.out.println("添加成功");
        return "redirect:/selectAll";
    }


    @RequestMapping(value = "delete")
    public String delete(Integer uId){

        System.out.println("删除");
        userMapper.deleteByPrimaryKey(uId);
        return "redirect:/selectAll";
    }



    @RequestMapping(value = "edit")
    public String edit(Model model,Integer uId){
        System.out.println("修改");
        User user = userMapper.selectByPrimaryKey(uId);
        model.addAttribute("user",user);
        return "edit.jsp";
    }

    @RequestMapping(value = "update")
    public String update(User user){
        userMapper.updateByPrimaryKeySelective(user);
        return "redirect:/selectAll";
    }


    @RequestMapping(value = "fileUpload")
    public String upload(MultipartFile[] file) throws IOException {


        for (MultipartFile m:file) {
            File file1 = new File("E:\\ima\\" + m.getOriginalFilename());
            m.transferTo(file1);
        }

        return "redirect:/selectAll";
    }


    @RequestMapping(value = "/getAll")
    public String getAllU(Model model){

        System.out.println("成功");
        List<User> users=null;
        Long   da1=System.currentTimeMillis();
        String key="com.zsq.dao.UserMapper.selectUserlistAll";
//
        String data=redisChahe.getDataFromRedis(key);
//
        if(data==null){

            System.out.println("走数据库");
            users= userMapper.selectUserlistAll();

            String userjson= JSON.toJSONString(users);
            redisChahe.setDataToRedis(key,userjson);

        }else {

            System.out.println("走redis");
            users=JSON.parseArray(data,User.class);
        }
//
        Long da2=System.currentTimeMillis();
//
        System.out.println("时间差："+(da2-da1));
        System.out.println(users.size());
//
        model.addAttribute("us",users);

        return "rdi.jsp";
//
    }
    Integer i=1;
    @RequestMapping(value = "preventForm")
    @AvoidDuplicateSubmission(needSaveToken =true)
    public String preventForm(User user){
        System.out.println("表单提交"+i);
        i++;
        return "successTwo.jsp";
    }



}