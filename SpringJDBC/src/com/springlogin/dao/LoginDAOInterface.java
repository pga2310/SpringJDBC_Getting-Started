package com.springlogin.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.springlogin.bean.UserBean;


public interface LoginDAOInterface {
	public abstract void setDataSource(DataSource dataSource);
	public abstract boolean authenticateUser(UserBean userBean);
	public abstract UserBean getUserList(UserBean userBean);
}