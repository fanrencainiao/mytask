package com.qjxs.biz;

import com.google.common.collect.Lists;
import com.qjxs.common.ex.ServiceException;
import com.qjxs.common.jpapage.PageSpringHelp;
import com.qjxs.domain.QUser;
import com.qjxs.domain.User;
import com.qjxs.domain.qry.UserQry;
import com.qjxs.repository.UserRepository;
import com.qjxs.service.UserService;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Log apilog=LogFactory.getLog("api.user.log");

	@Autowired
	private UserRepository repository;

	@Override
	public User save(User user) {
		apilog.debug(user);
		return repository.save(user);
	}

	@Override
	public void delete(UserQry qry) {
		repository.delete(qry);
	}

	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteByIds(List<String> ids) {
		ids.forEach(id -> repository.deleteById(id));
	}

	@Override
	public User findById(String id) {

		Optional<User> o = repository.findById(id);
		if (o.isPresent())
			return o.get();
		else
			return null;
	}

	@Override
	public List<User> query(UserQry qry) {

		return Lists.newArrayList(repository.findAll(this.getPredicate(qry)));
	}

	@Override
	public Page<User> queryPage(UserQry qry) {
		Predicate p = this.getPredicate(qry);
		Pageable pageable = PageSpringHelp.convert(qry.getPrama());
		return repository.findAll(p, pageable);
	}

	@Override
	public Long count(UserQry qry) {
		return repository.count(this.getPredicate(qry));
	}

	private Predicate getPredicate(UserQry qry) {
		BooleanBuilder p = new BooleanBuilder();
		if (qry.getUserName() != null)
			p.and(QUser.user.userName.eq(qry.getUserName()));
		if (qry.getUserName() != null)
			p.and(QUser.user.passWorld.eq(qry.getPassWorld()));

		return p;
	}


}
