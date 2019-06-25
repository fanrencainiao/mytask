package com.qjxs.repository.mongo;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.qjxs.domain.User;
/**
 * 更多mongdb数据库
 * @author cf
 *
 */
@Configuration
public class MoreMongdb {
	
	private Morphia morphia;
	private Datastore ds;


	
	@Bean(name = "morphia")
	public Morphia morphia() {
		morphia = new Morphia();
		// morphia.mapPackage("com.uvwxyz.intv.vo", true);
		//mapPackage("cn.xyz.mianshi.vo", morphia);
		
		morphia.mapPackage("com.qjxs.domain");
		return morphia;
	}

	@Bean(name = "dsForRW")
	public Datastore dsForRW(MongoClient mongoClient) {
		ds = morphia().createDatastore(mongoClient, "mytask");
		
		ds.ensureIndexes();
		ds.ensureCaps();
		
		try {
			BasicDBObject keys = new BasicDBObject();
			keys.put("coordinate", "2d");
			keys.put("nickname", 1);
			keys.put("sex", 1);
			keys.put("birthday", 1);
			keys.put("active", 1);

			DBCollection dbCollection = ds.getCollection(User.class);
			dbCollection.createIndex(keys);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

}
