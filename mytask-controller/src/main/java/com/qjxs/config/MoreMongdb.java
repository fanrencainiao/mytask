package com.qjxs.config;
import java.util.Arrays;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
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

	private MongoClient twoMongoClient;
	
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
		ds = morphia().createDatastore(mongoClient, "mytasks");
		ds.ensureIndexes();
		ds.ensureCaps();
		
		try {
			//初始化设置索引
//			BasicDBObject keys = new BasicDBObject();
//			keys.put("coordinate", "2d");
//			keys.put("nickname", 1);
//			keys.put("sex", 1);
//			keys.put("birthday", 1);
//			keys.put("active", 1);
//
//			DBCollection dbCollection = ds.getCollection(User.class);
//			dbCollection.createIndex(keys);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}
	
//	@Bean(name = "twoMongoClient", destroyMethod = "close")
//	public MongoClient mongo()   {
//		try {
//			List<ServerAddress> seeds = Lists.newArrayList();
//			ServerAddress address=null;
//			String[] detail = null;
////			for (String host : mongoConfig.getUri().split(",")) {
////				detail = host.split(":");
////				address=new ServerAddress(detail[0],Integer.valueOf(detail[1])) ;
////				seeds.add(address);
////				System.out.println("MongoDB host    "+address.getHost()+"  port  "+address.getPort());
////			}
//			address=new ServerAddress("127.0.0.1",28018);
//			seeds.add(address);
//			MongoClientOptions options= getMongoClientOptions();
//			 
//			 MongoCredential credential =null;
//			 //是否配置了密码
////			 if(!StringUtil.isEmpty(mongoConfig.getUsername())&&!StringUtil.isEmpty(mongoConfig.getPassword()))
////				 credential = MongoCredential.createScramSha1Credential(mongoConfig.getUsername(), mongoConfig.getDbName(), 
////						 mongoConfig.getPassword().toCharArray());
//			if(null==credential)
//				twoMongoClient = new MongoClient(seeds,options);
//			else 
//				twoMongoClient = new MongoClient(seeds,Arrays.asList(credential),options);
//			//mongoClient.setReadPreference(ReadPreference.nearest());
//			return twoMongoClient;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return twoMongoClient;
//		}
//		
//
//	}
//	
//	private  MongoClientOptions options=null;
//	public MongoClientOptions getMongoClientOptions() {
//		if(null==options) {
//			MongoClientOptions.Builder builder = MongoClientOptions.builder();
//			builder.socketKeepAlive(true);
////			builder.connectTimeout(mongoConfig.getConnectTimeout());
////			builder.socketTimeout(mongoConfig.getSocketTimeout());
////			builder.maxWaitTime(mongoConfig.getMaxWaitTime());
//			builder.connectTimeout(20000);
//			builder.socketTimeout(20000);
//			builder.maxWaitTime(20000);
//			builder.heartbeatFrequency(10000);// 心跳频率
//			
//			builder.readPreference(ReadPreference.nearest());
//			 options= builder.build();
//			 
//		}
//		return options;
//	}


}
