package com.soft.demo.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Slf4j
public class updateScheduled {

    @Value("${define.id}")
    private Integer id;

    @Scheduled(cron="${scheduled.cron}")
//    @Scheduled(fixedDelay = 30000) //每30秒执行一次
    public void datass(){
        log.info("开始实时获取数据");
        try{
            log.info("开始实时获取数据"+ new Date());
        }catch (Exception e){
            log.info("开始实时获取数失败"+ e);
        }
        log.info("开始实时获取数据结束");
    }

}
