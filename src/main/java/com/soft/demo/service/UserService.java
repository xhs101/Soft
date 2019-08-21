package com.soft.demo.service;

import com.soft.demo.model.UserEntity;
import com.soft.demo.repository.UserRepository;
import com.soft.demo.web.exceptions.DataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 登录验证
     * @param account 账号
     * @param password 密码
     * @return
     */
    public UserEntity fiandAccount(String account, String password) {
        // 根据账号查询
        UserEntity allByAccount = userRepository.findAllByAccountAndPassword(account,password);
        // 如果不为空
        if (allByAccount != null) {
            return allByAccount;
        } else {
        throw new NullPointerException("账号密码错误！");
        }
    }
}
