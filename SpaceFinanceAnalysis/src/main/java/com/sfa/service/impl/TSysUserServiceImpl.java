package com.sfa.service.impl;

import com.sfa.dao.TSysUserMapper;
import com.sfa.model.TSysUser;
import com.sfa.service.TSysUserService;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/12.
 */
@Service
@Transactional
public class TSysUserServiceImpl extends AbstractService<TSysUser> implements TSysUserService {
    @Resource
    private TSysUserMapper tSysUserMapper;

	@Override
	public TSysUser login(String tUserName, String tUserPwd) {
		return tSysUserMapper.login(tUserName,tUserPwd);
		
	}

}
