package com.qjxs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.qjxs.domain.Permission;
import com.qjxs.domain.qry.PermissionQry;


public interface PermissionService {

	Permission save(Permission bean);
    
    void delete(PermissionQry qry);
    
    void deleteById(String id);
    
    void deleteByIds(List<String> ids);
    
    Permission findById(String id);
    
    List<Permission> query(PermissionQry qry);
    
    Page<Permission> queryPage(PermissionQry qry);
    
    Long count(PermissionQry qry);
}
