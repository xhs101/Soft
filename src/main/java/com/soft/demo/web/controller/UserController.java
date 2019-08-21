package com.soft.demo.web.controller;

import com.soft.demo.model.UserEntity;
import com.soft.demo.service.UserService;
import com.soft.demo.web.VM.BasicResultVM;
import com.soft.demo.web.exceptions.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    private static final  BasicResultVM rest = new BasicResultVM();

    @GetMapping(value = "/login")
    public BasicResultVM login(String userName,String password){
        if(userName == null || "".equals(userName)){
            throw new ParamException();
        }
        if(password == null || "".equals(password)){
            throw new ParamException();
        }
        try{
            UserEntity userEntity = userService.fiandAccount(userName, password);
            if(userEntity != null){
                rest.setReturnCode(200);
                rest.setReturnDesc("登录成功！");
                rest.setReturnResult(null);
            }else {
                rest.setReturnCode(-1);
                rest.setReturnDesc("登录失败！");
                rest.setReturnResult(null);
            }
        }catch (Exception e){
            rest.setReturnCode(-1);
            rest.setReturnDesc("账号密码错误！");
            rest.setReturnResult(e.getMessage());
        }
        return rest;
    }
}
