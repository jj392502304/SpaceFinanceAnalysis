package com.sfa.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sfa.core.Mapper;
import com.sfa.model.TSysUser;

public interface TSysUserMapper extends Mapper<TSysUser> {
	TSysUser login(@Param("tUserName")String tUserName,@Param("tUserPwd") String tUserPwd);
}