package com.soft.demo.repository;

import com.soft.demo.model.serverlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface serverListRepository extends JpaRepository<serverlist,Integer>,JpaSpecificationExecutor{

    /**
     * 根据Id查询
     * @param Id
     * @return
     */
    serverlist findAllById(Integer Id);
}
