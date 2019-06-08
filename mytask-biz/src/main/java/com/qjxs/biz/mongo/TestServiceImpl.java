package com.qjxs.biz.mongo;

import java.util.List;

import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qjxs.domain.mongo.Test;
import com.qjxs.repository.mongo.TestRepository;

@Service
public class TestServiceImpl {
	@Autowired
	private TestRepository repository;
	
	public Key<Test> test(Test test) {
		return repository.save(test);
	}
	
	public List<Test> testl() {
		return repository.find().asList();
	}

}
