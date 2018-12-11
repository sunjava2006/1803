package com.profound.thchnology.mongo;

import com.mongodb.MongoClient;

public class MongoClientUtil {

	private static MongoClient client;
	
	static {
		client = new MongoClient("localhost", 27017);
	}
	
	public static MongoClient getClient() {
		return client;
	}
}
