package com.sun.test;

import java.util.List;

import com.sun.test.bean.User;
import com.sun.test.exception.DataNotFoundException;
import com.sun.test.util.DataUtil;
import com.sun.test.util.PrintUtil;

public class Test {

	public static void main(String[] args) throws DataNotFoundException {
		DataUtil datautil = DataUtil.getInstance();
		List<User> userList = datautil.loadDataFromDB();
		PrintUtil.getInstance().printData(userList);
	}
}
