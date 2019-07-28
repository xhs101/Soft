package com.soft.demo.model;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "t_cc_time")
public class ConferencesOrg {
    // 编号
    private Integer ID;
    // 组织名称
    private String AUDIT_ID;
    // 所属组织
    private Integer belongTo;
}
