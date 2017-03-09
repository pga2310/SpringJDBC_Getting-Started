package com.springlogin.service;

import java.util.List;
import java.util.Map;

import com.springlogin.bean.UserBean;

public interface LoginServiceInterface {
	public abstract boolean authenticateUser(UserBean userBean);
	public abstract UserBean getUserList(UserBean userBean);
}