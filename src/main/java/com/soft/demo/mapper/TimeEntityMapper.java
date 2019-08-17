package com.soft.demo.mapper;

import com.soft.demo.model.TimeEntity;
import com.tigon.mybatis.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimeEntityMapper extends BaseMapper<Integer, TimeEntity> {
    // 根据AppId查询服务时间
    List<TimeEntity> queryAuditIdTime(String AppletId);
}