package com.qjxs.repository.mongo;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.dao.DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qjxs.domain.mongo.Test;

@Repository
public class TestRepository  extends BasicDAO<Test, ObjectId>{
	@Autowired
	public TestRepository(Datastore ds) {
		super(ds);
	}
	

}
