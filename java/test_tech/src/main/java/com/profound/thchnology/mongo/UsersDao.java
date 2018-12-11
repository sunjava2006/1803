package com.profound.thchnology.mongo;

import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class UsersDao {
	public static void listAllUsers() {
		MongoClient client = MongoClientUtil.getClient();
		MongoDatabase db = client.getDatabase("blog");
		MongoCollection<Document> users = db.getCollection("users");
	    FindIterable<Document> ite = users.find();
	    for(Document d : ite) {
	    	System.out.println(d);
	    	
	    }
	}
	
	public static void add(String regName, String pwd, String gender, Date birthday) {
		MongoClient client = MongoClientUtil.getClient();
		MongoDatabase db = client.getDatabase("blog");
		MongoCollection<Document> users = db.getCollection("users");
		Document obj = new Document();
		obj.append("reg_name", regName);
		obj.append("pwd", pwd);
		obj.append("gender", gender);
		obj.append("birthday", birthday);
		users.insertOne(obj);
		
	}
	
	public static void main(String[] args) {
		 add("李东", "123abc", "female", new Date());
		
		listAllUsers();
	}
}
