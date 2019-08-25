package com.soft.demo.web.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDto {
    private String account;
    private String name;
    private String password;
    private String phone;
    private String email;
    private Date birthday;
    private String addres;
}
