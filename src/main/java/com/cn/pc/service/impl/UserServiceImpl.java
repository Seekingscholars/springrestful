package com.cn.pc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.pc.dao.IUserDao;
import com.cn.pc.entity.UserEntity;
import com.cn.pc.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserDao iUserDao;
	
	public UserEntity getUserById(int userId) {
		// TODO Auto-generated method stub
		System.out.println("service ... " + userId);
		return iUserDao.findByPrimaryKey(userId);
	}

}
