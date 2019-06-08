package com.qjxs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.qjxs.domain.Role;
import com.qjxs.domain.User;
import com.qjxs.domain.qry.RoleQry;
import com.qjxs.domain.qry.UserQry;


public interface RoleService {

	Role save(Role bean);
    
    void delete(RoleQry qry);
    
    void deleteById(String id);
    
    void deleteByIds(List<String> ids);
    
    Role findById(String id);
    
    List<Role> query(RoleQry qry);
    
    Page<Role> queryPage(RoleQry qry);
    
    Long count(RoleQry qry);
}
