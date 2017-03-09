package com.springlogin.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.springlogin.bean.UserBean;


public class LoginDAO implements LoginDAOInterface {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@SuppressWarnings("deprecation")
	public boolean authenticateUser(UserBean userBean){
		String sql ="SELECT COUNT(firstname) FROM login where uname = ? and password = ?";
		boolean userExists = false;
		int count = jdbcTemplate.queryForObject(
                sql, new Object[] { userBean.getUserId(), userBean.getPassword() }, Integer.class);
		if(count==1){
			userExists = true;
//			getUserList();
		}
		return userExists;
		
	}
	
	public UserBean getUserList(UserBean userBean) {
  			  
		String sql = "select firstname, lastname from login where uname='"+userBean.getUserId()+"'";  
		
		List<Map<String,Object>> userList = jdbcTemplate.queryForList(sql);
		
		for(Map obj: userList){
			userBean.setFirstname(obj.get("firstname").toString());
			userBean.setLastname(obj.get("lastname").toString());
		}
		
//		System.out.println(userBean.getFirstname());
//		System.out.println(userBean.getLastname());
		return userBean;
		
	}  
	
}