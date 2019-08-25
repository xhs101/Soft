package com.soft.demo.web.controller;

import com.soft.demo.model.UserEntity;
import com.soft.demo.service.UserService;
import com.soft.demo.web.Dto.UserDto;
import com.soft.demo.web.VM.BasicResultVM;
import com.soft.demo.web.exceptions.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.util.StringUtil;

@RestController
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    private static final BasicResultVM rest = new BasicResultVM();

    /**
     * 登录验证
     *
     * @param userName 账号
     * @param password 密码
     * @return
     */
    @GetMapping(value = "/login")
    public BasicResultVM login(String userName, String password) {
        if (userName == null || "".equals(userName)) {
            throw new ParamException();
        }
        if (password == null || "".equals(password)) {
            throw new ParamException();
        }
        try {
            UserEntity userEntity = userService.fiandAccount(userName, password);
            if (userEntity != null) {
                rest.setReturnCode(200);
                rest.setReturnDesc("登录成功！");
                rest.setReturnResult(null);
            } else {
                rest.setReturnCode(-1);
                rest.setReturnDesc("登录失败！");
                rest.setReturnResult(null);
            }
        } catch (Exception e) {
            rest.setReturnCode(-1);
            rest.setReturnDesc("账号密码错误！");
            rest.setReturnResult(e.getMessage());
        }
        return rest;
    }

    /**
     * 注册账号
     *
     * @param userDto
     * @return
     */
    @PostMapping(value = "/regist")
    public BasicResultVM regist(@RequestBody UserDto userDto) {
        if (userDto == null) {
            throw new ParamException();
        }
        try {
            // 注册账号
            userService.registUser(userDto);
            rest.setReturnCode(200);
            rest.setReturnDesc("注册成功！");
            rest.setReturnResult(null);
        } catch (Exception e) {
            rest.setReturnCode(-1);
            rest.setReturnDesc("注册失败！");
            rest.setReturnResult(e.getMessage());
        }
        return rest;
    }

    /**
     * 根据账号和用户名修改密码
     *
     * @param account  账号
     * @param password 密码
     * @param name     用户名
     * @return
     */
    @PostMapping(value = "/updatePwd")
    public BasicResultVM updatePwd(@RequestBody UserDto userDto) {
        String account = userDto.getAccount();
        String password = userDto.getPassword();
        String name = userDto.getName();
        String phone = userDto.getPhone();
        if (StringUtil.isEmpty(account) || StringUtil.isEmpty(password) || StringUtil.isEmpty(name)) {
            throw new ParamException();
        }
        try {
            userService.editPwd(account, password, name);
            rest.setReturnCode(200);
            rest.setReturnDesc("修改成功！");
            rest.setReturnResult(null);
        } catch (Exception e) {
            rest.setReturnCode(-1);
            rest.setReturnDesc("修改失败！");
            rest.setReturnResult(e.getMessage());
        }
        return rest;
    }
}
