package com.home.app.dao;
import com.home.app.entities.UserInfo;
public interface UserInfoDAO {
	public abstract UserInfo getActiveUser(String userName);
}