package com.soft.demo.model;

import com.tigon.model.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "e_dish_user")
public class UserEntity extends BaseModel<Integer> {
    @Id
    // 主键自增长
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    // 账号
    private String account;

    // 密码
    private String password;

    // 用户名
    private String name;

    // 电话
    private Integer phone;

    // 用户名
    private String email;

    // 生日
    private Date birthday;

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
    private Integer is_delete;
}
