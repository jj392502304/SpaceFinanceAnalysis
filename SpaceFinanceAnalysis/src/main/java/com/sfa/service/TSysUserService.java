package com.sfa.service;
import com.sfa.model.TSysUser;
import com.sfa.core.Service;


/**
 * Created by CodeGenerator on 2018/09/12.
 */
public interface TSysUserService extends Service<TSysUser> {

	TSysUser login(String tUserName, String tUserPwd);

}
