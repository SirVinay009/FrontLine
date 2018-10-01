package com.frontline.dao;

import com.frontline.model.User;

public interface UserDAO {

	public boolean registerUser(User user);
	public boolean modifyUser(User user);
	public User getUser(String username);
	
}
