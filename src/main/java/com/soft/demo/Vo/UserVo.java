package com.soft.demo.Vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo {

    // 主键
    private Integer id;

    // 账号
    private String account;

    // 密码
    private String password;

    // 用户名
    private String name;

    // 电话
    private String phone;

    // 用户名
    private String email;

    // 生日
    private String birthday;

    // 地址
    private String address;

    // 创建时间
    private Date create_time;

    // 创建者
    private String create_author;

    // 修改时间
    private Date update_time;

    // 修改者
    private String update_author;

    // 是否有效
    private int is_delete;
}
