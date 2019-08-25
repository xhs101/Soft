package com.soft.demo.service;

import com.soft.demo.model.UserEntity;
import com.soft.demo.repository.UserRepository;
import com.soft.demo.web.Dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 登录验证
     *
     * @param account  账号
     * @param password 密码
     * @return
     */
    public UserEntity fiandAccount(String account, String password) {
        // 验证用户名是否存在
        UserEntity allbyAccount = userRepository.findAllByAccount(account);
        // 如果存在验证密码是否正确，否则返回用户不存在
        if (allbyAccount != null) {
            // 根据账号查询和密码查询，验证用户名密码是否正确
            UserEntity allByAccount = userRepository.findAllByAccountAndPassword(account, password);
            // 如果不为空则正确，否则不正确
            if (allByAccount != null) {
                return allByAccount;
            } else {
                throw new NullPointerException("密码错误,重新输入！");
            }
        } else {
            throw new NullPointerException("账号不存在！");
        }
    }

    /**
     * 注册账号
     *
     * @param user
     */
    public void registUser(UserDto user) {
        Date date = new Date();
        // 验证账号是否存在
        UserEntity allByAccount = userRepository.findAllByAccount(user.getAccount());
        if (allByAccount != null) {
            throw new NullPointerException("账号已存在！");
        } else {
            UserEntity userEntity = new UserEntity();
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            userEntity.setId(uuid);
            userEntity.setAccount(user.getAccount());
            userEntity.setName(user.getName());
            userEntity.setPassword(user.getPassword());
            userEntity.setPhone(user.getPhone());
            userEntity.setEmail(user.getEmail());
            userEntity.setBirthday(user.getBirthday());
            userEntity.setAddress(user.getAddres());
            userEntity.setCreate_author(user.getAccount());
            userEntity.setCreate_time(date);
            userEntity.setUpdate_author(user.getAccount());
            userEntity.setUpdate_time(date);
            userEntity.setIs_delete(0);
            userRepository.save(userEntity);
        }
    }

    /**
     * 根据账号和用户名修改密码
     *
     * @param account  账号
     * @param password 密码
     * @param name     用户名
     */
    public void editPwd(String account, String password, String name) {
        // 验证账号是否存在
        UserEntity allByAccount = userRepository.findAllByAccount(account);
        if (allByAccount != null) {
            if (password.equals(allByAccount.getPassword())) {
                throw new NullPointerException("新密码不能与旧密码一样！");
            }
            if (name.equals(allByAccount.getName())) {
                allByAccount.setPassword(password);
                allByAccount.setUpdate_author(account);
                allByAccount.setUpdate_time(new Date());
                userRepository.save(allByAccount);
            } else {
                throw new NullPointerException("账号与用户名不匹配！");
            }
        } else {
            throw new NullPointerException("账号不存在！");
        }
    }
}
