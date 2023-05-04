package com.aml.worldCheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aml.worldCheck.entity.WorldCheckCallAPIEntity;

public interface AmlDataCheckRepository extends JpaRepository<WorldCheckCallAPIEntity, Long>{

}
