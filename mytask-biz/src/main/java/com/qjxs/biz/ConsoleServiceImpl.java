package com.qjxs.biz;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjxs.domain.User;
import com.qjxs.domain.qry.UserQry;
import com.qjxs.service.ConsoleService;
import com.qjxs.service.UserService;
@Service
public class ConsoleServiceImpl implements ConsoleService {

	@Autowired
	private UserService us;
	
	@Override
	public User login(String userName, String passworld) {
		UserQry uq=new UserQry();
		uq.setUserName(userName);
		uq.setPassWorld(passworld);
		List<User> query = us.query(uq);
		if(CollectionUtils.isNotEmpty(query))
			return query.get(0);
		return null;
	}

}
