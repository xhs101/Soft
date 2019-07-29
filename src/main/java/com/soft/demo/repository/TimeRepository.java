package com.soft.demo.repository;

import com.soft.demo.model.TimeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<TimeEntity,Integer>, JpaSpecificationExecutor {

    Page<TimeEntity> findByAuditId(String AppId,Pageable pageable);
}
