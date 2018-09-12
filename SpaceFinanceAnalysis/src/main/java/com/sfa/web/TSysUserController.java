package com.sfa.web;
import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.TSysUser;
import com.sfa.service.TSysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/09/10.
*/
@RestController
@RequestMapping("/t/sys/user")
public class TSysUserController {
    @Resource
    private TSysUserService tSysUserService;

    @PostMapping("/add")
    public Result add(TSysUser tSysUser) {
        tSysUserService.save(tSysUser);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        tSysUserService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TSysUser tSysUser) {
        tSysUserService.update(tSysUser);
        return ResultGenerator.genSuccessResult();
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
}
