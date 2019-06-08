package com.qjxs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.qjxs.domain.Permission;
@Repository
public interface PermissionRepository extends JpaRepository<Permission,String> ,QuerydslPredicateExecutor<Permission>{



}
