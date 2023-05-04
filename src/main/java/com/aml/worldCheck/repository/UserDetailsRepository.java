package com.aml.worldCheck.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aml.worldCheck.entity.UserDetailsEntity;

public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Long>{
	
	 UserDetailsEntity getUserByUsername(String name);

}
