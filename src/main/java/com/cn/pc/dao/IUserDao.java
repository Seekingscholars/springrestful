package com.cn.pc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.pc.entity.UserEntity;

public interface IUserDao {
	int deleteByPrimaryKey(Integer id);

    int save(UserEntity record);
    
    int update(UserEntity record);

    UserEntity findByPrimaryKey(Integer id);

    UserEntity query(UserEntity record);
    
    List<UserEntity> listByPrimaryKeys(@Param(value = "ids") Integer[] ids);
}
