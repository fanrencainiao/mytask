package com.qjxs.controller.mongo;

import org.mongodb.morphia.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qjxs.biz.mongo.TestServiceImpl;
import com.qjxs.common.utils.Result;
import com.qjxs.controller.AbstractController;
import com.qjxs.domain.mongo.Test;
import com.qjxs.repository.mongo.TestmRepository;

@RestController
@RequestMapping("/user/")
public class MongoTestController extends AbstractController{
	
	@Autowired
	private TestServiceImpl t;
	
	@Autowired
	private TestmRepository tm;
	
	@RequestMapping("motest")
	public Object motest(){
		Test test=new Test();
		test.setTname("ss");
		Key<Test> tt=t.test(test);
		tt.getCollection();
		tt.getClass();
		tt.getType();
		System.out.println(t.testl().get(0).getTid());
		return Result.success(t.testl());
	}
	
	@RequestMapping("motests")
	public Object motests(){
		Test test=new Test();
		test.setTname("ssmm");
		Key<Test> tt=tm.save(test);
		tt.getCollection();
		tt.getClass();
		tt.getType();
		System.out.println(tm.find().asList().get(0).getTid());
		return Result.success(tm.find().asList());
	}

}
