package com.soft.demo.service;

import com.soft.demo.Vo.TimeVo;
import com.soft.demo.mapper.TimeEntityMapper;
import com.soft.demo.model.TimeEntity;
import com.soft.demo.repository.TimeRepository;
import com.soft.demo.web.Util.ECloudBeanUtilsBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class TimeService {
    @Autowired
    private TimeEntityMapper timeEntityMapper;

    @Autowired
    private TimeRepository timeRepository;

    /**
     * 根据AppId查询服务时间
     */
    public List<TimeVo> queryTime(String AppId) {
        // 定义返回对象
        List<TimeVo> tempList = new ArrayList<>();
        try {
            // 根据AppId查询服务时间
            List<TimeEntity> timeEntity = timeEntityMapper.queryAuditIdTime(AppId);
            // 判断是否检索到数据
            if (timeEntity.size() == 0) {
                throw new NullPointerException("暂无数据！");
            } else {
                // for循环拷贝属性
                for (TimeEntity timeList : timeEntity) {
                    TimeVo timeVo = new TimeVo();
                    // 拷贝工具类(excluede排除)
                    ECloudBeanUtilsBean.getInstance().copyProperties(timeVo, timeList);
                    tempList.add(timeVo);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("错误信息：" + e.getMessage());
        }
        return tempList;
    }

    public Page<TimeEntity> findAll(Integer pageNumber,Integer pageSize,String AppId,String partyName){
        Specification<TimeEntity> specification = (root, query, cb) -> {
            String partyNmaeLike = null;
            if(partyName != null){
                partyNmaeLike = "%" + "%";
            }else{
                partyNmaeLike = "%%";
            }
            Predicate auditId = cb.equal(root.get("auditId").as(String.class), AppId);
            Predicate partyName1 = cb.like(root.get("partyName").as(String.class), partyNmaeLike);
            Predicate isDeleted = cb.equal(root.get("isDeleted").as(String.class), 0);
            Predicate and = cb.and(auditId, partyName1);
            and = cb.and(and, isDeleted);
            query.where(and);
            return null;
        };
        return timeRepository.findAll(specification, new PageRequest(pageNumber - 1, pageSize, new Sort(Sort.Direction.ASC, "id")));
    }
}
