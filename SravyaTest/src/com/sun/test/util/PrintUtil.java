package com.sun.test.util;

import java.util.List;

import com.sun.test.bean.User;
import com.sun.test.exception.DataNotFoundException;

/**
 * Util Class to print data 
 * @author Sravya M
 *
 */
public class PrintUtil {

	private static PrintUtil printUtil = null;
	
	/**
	 * Static Factory method to return single instane
	 */
	public static PrintUtil getInstance(){
		if(printUtil == null){
			printUtil = new PrintUtil();
		}
		return printUtil;	
	}
	
	public void printData(List<User> users) throws DataNotFoundException{
		if(null == users || users.size() <= 0){
			throw new DataNotFoundException(1001,"User Data Not Found");
		}
		
		for(User user:users){
			System.out.println(user);
			System.out.println("*********************************************************************************");
		}
	}
}
