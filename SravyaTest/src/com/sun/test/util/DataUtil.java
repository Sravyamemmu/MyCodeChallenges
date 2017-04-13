package com.sun.test.util;

import java.util.ArrayList;
import java.util.List;

import com.sun.test.bean.User;

/**
 * 
 * @author Sravya M
 * Class to populate Data
 *
 */
public class DataUtil {

	private static DataUtil datautil = null;
	
	/*
	 * Static Factory method to return unique instance
	 */
	public static DataUtil getInstance(){
		if(null == datautil){
			datautil = new DataUtil();
		}
		return datautil;
	}
	
	/**
	 * Method to load data from database
	 * @return  List<User>
	 */
	public List<User> loadDataFromDB(){
		//TO-DO - Code to connect to the data base
		List<User> userList = new ArrayList<User>();
		User user = new User();
		user.setId(1);
		user.setName("Andy");
		user.setPhone(2345678901l);
		user.setAddress("Dummy Address1");
		userList.add(user);

		user = new User();
		user.setId(2);
		user.setName("Nan");
		user.setPhone(9876543312l);
		user.setAddress("Dummy Address2");		
		userList.add(user);
		
		return userList;
	}
	
}
