package com.soft.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Setter
@Table(name = "t_cc_record_serverlist")
public class serverlist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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