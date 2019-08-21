package com.soft.demo.repository;

import com.soft.demo.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer>, JpaSpecificationExecutor {

    /**
     * 登录验证
     * @param account 账号
     * @param password 密码
     * @return
     */
    UserEntity findAllByAccountAndPassword(String account,String password);
}
