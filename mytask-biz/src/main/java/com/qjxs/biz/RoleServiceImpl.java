package com.qjxs.biz;

import com.google.common.collect.Lists;
import com.qjxs.common.jpapage.PageSpringHelp;
import com.qjxs.domain.QRole;
import com.qjxs.domain.Role;
import com.qjxs.domain.qry.RoleQry;
import com.qjxs.repository.RoleRepository;
import com.qjxs.service.RoleService;
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
public class RoleServiceImpl implements RoleService {
	
	Log apilog=LogFactory.getLog("api.role.log");

	@Autowired
	private RoleRepository repository;

	@Override
	public Role save(Role Role) {
		return repository.save(Role);
	}

	@Override
	public void delete(RoleQry qry) {
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
	public Role findById(String id) {

		Optional<Role> o = repository.findById(id);
		if (o.isPresent())
			return o.get();
		else
			return null;
	}

	@Override
	public List<Role> query(RoleQry qry) {

		return Lists.newArrayList(repository.findAll(this.getPredicate(qry)));
	}

	@Override
	public Page<Role> queryPage(RoleQry qry) {
		Predicate p = this.getPredicate(qry);
		Pageable pageable = PageSpringHelp.convert(qry.getPrama());
		return repository.findAll(p, pageable);
	}

	@Override
	public Long count(RoleQry qry) {
		return repository.count(this.getPredicate(qry));
	}

	private Predicate getPredicate(RoleQry qry) {
		BooleanBuilder p = new BooleanBuilder();
		if (qry.getRoleName() != null)
			p.and(QRole.role.roleName.eq(qry.getRoleName()));

		return p;
	}


}
