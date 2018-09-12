package com.sfa.web;

import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.TPerson;
import com.sfa.model.TSysUser;
import com.sfa.model.UserAndPerson;
import com.sfa.service.TPersonService;
import com.sfa.service.TSysUserService;
import com.sfa.util.RandomUtils;
import com.sfa.util.UUID;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * Created by CodeGenerator on 2018/09/12.
 */
@RestController
@RequestMapping("/t/sys/user")
public class TSysUserController {
	@Resource
	private TSysUserService tSysUserService;
	@Resource
	private TPersonService tpersonservice;

	@PostMapping("/add")
	public Result add(@RequestBody UserAndPerson up) {
		TPerson userMobile= tpersonservice.findBy("tMobile", up.person.gettGender());
		TPerson userEmail = tpersonservice.findBy("tEmail", up.person.gettGender());
		TSysUser person = tSysUserService.findBy("tUserName", up.user.gettUserName());
		if (userMobile != null) {
			return ResultGenerator.genFailResult("手机号已被注册");
		}
		if (person != null) {
			return ResultGenerator.genFailResult("用户名已被注册");
		}
		if(userEmail!=null){
			return ResultGenerator.genFailResult("邮箱已被注册");
		}

		up.user.settUserId(UUID.randomUUID());// TSysUser表的UUID
		up.person.settPresonId(UUID.randomUUID());// TPerson表关联的User表的UUID
		up.person.settUserId(up.user.gettUserId());// TPerson表的UUID
		up.user.settUserPwd(RandomUtils.encryption(up.user.gettUserPwd()));
		tSysUserService.save(up.user);
		tpersonservice.save(up.person);
		return ResultGenerator.genSuccessResult();
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam String id) {
		tSysUserService.deleteById(id);
		return ResultGenerator.genSuccessResult();
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody TSysUser user) {
		TSysUser exist = tSysUserService.findBy("tUserName", user.gettUserName());
		if(exist!=null){
			user.settUserId(exist.gettUserId());
			tSysUserService.update(user);
			return ResultGenerator.genSuccessResult();
		}
		return ResultGenerator.genFailResult("该用户不存在");
	}
	@PostMapping("/modifypwd")
	public Result modifypwd(@RequestParam String username, @RequestParam String oldpwd, @RequestParam String newpwd) {
		oldpwd=RandomUtils.encryption(oldpwd);
		newpwd=RandomUtils.encryption(newpwd);
		TSysUser login = tSysUserService.login(username, oldpwd);
		if (login != null) {
			TSysUser user = new TSysUser();
			user.settUserId(login.gettUserId());
			user.settUserName(username);
			user.settUserPwd(newpwd);
			tSysUserService.update(user);
			return ResultGenerator.genSuccessResult();
		}

		return ResultGenerator.genFailResult("旧密码不正确");
	}

	@PostMapping("/detail")
	public Result detail(@RequestParam String id) {
		TSysUser tSysUser = tSysUserService.findById(id);
		return ResultGenerator.genSuccessResult(tSysUser);
	}

	@PostMapping("/list")
	public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
		PageHelper.startPage(page, size);
		List<TSysUser> list = tSysUserService.findAll();
		PageInfo pageInfo = new PageInfo(list);
		return ResultGenerator.genSuccessResult(pageInfo);
	}

	@PostMapping("/login")
	public Result login(@RequestParam String tUserName, @RequestParam String tUserPwd) {
		tUserPwd = RandomUtils.encryption(tUserPwd);
		TSysUser login = tSysUserService.login(tUserName, tUserPwd);
		if (login != null) {
			return ResultGenerator.genSuccessResult(login);
		}
		return ResultGenerator.genFailResult("用户密码不存在");
	}
}
