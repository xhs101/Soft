package com.soft.demo.web.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ServerDto {
    private Integer id;

    private String serverName;

    private Integer port;

    private String serverUrl;

    private String serverUsername;

    private String serverPassword;

    private Integer isDeleted;

    private Date createTime;

    private Date modifiedTime;

    private String aes;
}
