package com.qjxs.controller;

import com.qjxs.common.redis.RedisUtil;
import com.qjxs.domain.User;
import com.qjxs.filter.AuthorizationFilterProperties;
import com.qjxs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    @Qualifier(value="afp")
    private AuthorizationFilterProperties ap;

    @RequestMapping("/save")
    public User saveUser(User user) {
//    	userService.save(user);
    	User u=new User();
    	u.setId("4028ab4e6aa77cbc016aa792cad00000");
    	u.setUsername("123");
    	userService.save(u);
        return u;
    }
    
    @RequestMapping("/jedis")
    public String saveJedis(String value) {
    	redisUtil.saveTimeKey("test1",value,10);
    	String v=redisUtil.getKey("test1");
    	System.out.println(ap.getRequestUriList());
        return v;
    }
}
