package com.qjxs.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.qjxs.domain.User;
import com.qjxs.domain.qry.UserQry;


public interface UserService {

    User save(User user);
    
    void delete(UserQry qry);
    
    void deleteById(String id);
    
    void deleteByIds(List<String> ids);
    
    User findById(String id);
    
    List<User> query(UserQry qry);
    
    Page<User> queryPage(UserQry qry);
    
    Long count(UserQry qry);
}
