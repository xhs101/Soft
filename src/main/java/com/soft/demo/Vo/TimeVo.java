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
public class TimeVo {
    private Long id;
	// 编号
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
