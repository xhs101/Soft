package com.soft.demo.mapper;

import com.soft.demo.model.serverlist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface serverlistMapper {
    List<serverlist> findServers ();
}