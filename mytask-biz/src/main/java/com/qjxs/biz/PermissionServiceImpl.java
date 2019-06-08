package com.qjxs.biz;

import com.google.common.collect.Lists;
import com.qjxs.common.jpapage.PageSpringHelp;
import com.qjxs.domain.QPermission;
import com.qjxs.domain.Permission;
import com.qjxs.domain.qry.PermissionQry;
import com.qjxs.repository.PermissionRepository;
import com.qjxs.service.PermissionService;
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
public class PermissionServiceImpl implements PermissionService {
	
	Log apilog=LogFactory.getLog("api.permission.log");

	@Autowired
	private PermissionRepository repository;

	@Override
	public Permission save(Permission bean) {
		return repository.save(bean);
	}

	@Override
	public void delete(PermissionQry qry) {
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
	public Permission findById(String id) {

		Optional<Permission> o = repository.findById(id);
		if (o.isPresent())
			return o.get();
		else
			return null;
	}

	@Override
	public List<Permission> query(PermissionQry qry) {
		return Lists.newArrayList(repository.findAll(this.getPredicate(qry)));
	}

	@Override
	public Page<Permission> queryPage(PermissionQry qry) {
		Predicate p = this.getPredicate(qry);
		Pageable pageable = PageSpringHelp.convert(qry.getPrama());
		return repository.findAll(p, pageable);
	}

	@Override
	public Long count(PermissionQry qry) {
		return repository.count(this.getPredicate(qry));
	}

	private Predicate getPredicate(PermissionQry qry) {
		BooleanBuilder p = new BooleanBuilder();
		if (qry.getPerName() != null)
			p.and(QPermission.permission.perName.eq(qry.getPerName()));
		return p;
	}


}
