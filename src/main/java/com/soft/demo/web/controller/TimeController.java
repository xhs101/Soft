package com.soft.demo.web.controller;

import com.soft.demo.Vo.TimeVo;
import com.soft.demo.model.TimeEntity;
import com.soft.demo.repository.TimeRepository;
import com.soft.demo.service.TimeService;
import com.soft.demo.web.VM.BasicResultVM;
import com.soft.demo.web.exceptions.DataException;
import com.soft.demo.web.exceptions.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/timeList")
@Slf4j
public class TimeController {

    @Autowired
    private TimeService timeService;
    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/queryTime")
    public BasicResultVM queryTime(String AppId) {
        BasicResultVM basicResultVM = new BasicResultVM();
        Boolean hasKey = redisTemplate.hasKey(AppId);
        if(hasKey){
            Object o = redisTemplate.opsForValue().get(AppId);
            basicResultVM.setReturnCode(200);
            basicResultVM.setReturnDesc("从redis中获取服务时间成功！");
            basicResultVM.setReturnResult(o);
            return basicResultVM;
        }
            if ("".equals(AppId)) {
                throw new ParamException();
            } else {
                List<TimeVo> timeVos = timeService.queryTime(AppId);
                if(timeVos.size() == 0){
                    throw new DataException();
                }else{
                    basicResultVM.setReturnCode(200);
                    basicResultVM.setReturnDesc("获取服务时间成功！");
                    basicResultVM.setReturnResult(timeVos);
                    redisTemplate.opsForValue().set(AppId,timeVos,60, TimeUnit.SECONDS);
                }
            }
        return basicResultVM;
    }

    /**
     * 分页查询服务时间
     * @param pageNumber 页码
     * @param pageSize pageSize
     * @param AppId
     * @param partyName
     * @return
     */
    @GetMapping(value = "/findAll")
    public BasicResultVM findAll(Integer pageNumber,Integer pageSize,String AppId,String partyName){
        BasicResultVM basicResultVM = new BasicResultVM();
        if("".equals(pageNumber) || "".equals(pageSize) || "".equals(AppId)){
            throw new ParamException();
        }
        Page<TimeEntity> all = timeService.findAll(pageNumber, pageSize, AppId, partyName);
        if(all != null){
            basicResultVM.setReturnCode(200);
            basicResultVM.setReturnDesc("分页获取服务时间成功！");
            basicResultVM.setReturnResult(all);
        }else{
            throw new DataException();
        }
        return basicResultVM;
    }

    /**
     * 分页查询服务时间
     * @param AppId
     * @param pageNumber
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/getTime")
    public BasicResultVM getTime(String AppId,Integer pageNumber,Integer pageSize){
        BasicResultVM basicResultVM = new BasicResultVM();
        if("".equals(AppId) || "".equals(pageNumber) || "".equals(pageSize)){
            throw new ParamException();
        }else{
            Page<TimeEntity> byAuditId = timeRepository.findByAuditId(AppId, new PageRequest(pageNumber - 1, pageSize));
            if(byAuditId != null){
                basicResultVM.setReturnCode(200);
                basicResultVM.setReturnDesc("分页获取服务时间成功！");
                basicResultVM.setReturnResult(byAuditId);
            }else {
                throw new DataException();
            }
        }
        return basicResultVM;
    }
}
