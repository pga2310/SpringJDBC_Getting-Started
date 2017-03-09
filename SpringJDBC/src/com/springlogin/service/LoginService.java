package com.springlogin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.springlogin.bean.UserBean;
import com.springlogin.dao.LoginDAOInterface;

public class LoginService implements LoginServiceInterface {

	@Autowired
	private LoginDAOInterface loginDAO;

	public boolean authenticateUser(UserBean userBean){
		return loginDAO.authenticateUser(userBean);
	}

	@Override
	public UserBean getUserList(UserBean userBean) {
		// TODO Auto-generated method stub
		return loginDAO.getUserList(userBean);
	}
}