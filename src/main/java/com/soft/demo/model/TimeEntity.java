package com.soft.demo.model;

import com.tigon.model.BaseModel;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_cc_time")
public class TimeEntity extends BaseModel<Integer> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String auditId;

    private String dayStart;

    private String dayEnd;

    private String timeStart;

    private String timeEnd;

    private String strategy;

    private String strategyDesc;

    private String partyId;

    private String partyName;

    private Date createTime;

    private Date modifiedTime;

    private Boolean isDeleted;

}