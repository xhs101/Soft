package com.soft.demo.scheduled;

import com.soft.demo.model.serverlist;
import com.soft.demo.service.serverListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Slf4j
public class updateScheduled {

    @Value("${define.id}")
    private Integer id;

    @Autowired
    private serverListService ServerListService;

    @Scheduled(cron="${scheduled.cron}")
//    @Scheduled(fixedDelay = 30000) //每30秒执行一次
    public void datass(){
        log.debug("开始实时获取数据");
        try{
            serverlist serverlist = ServerListService.find(id);
            log.info("时间："+ new Date() +"数据:"+ serverlist);
        }catch (Exception e){
            log.info("开始实时获取数失败"+ e);
        }
        log.info("开始实时获取数据结束");
    }

}
