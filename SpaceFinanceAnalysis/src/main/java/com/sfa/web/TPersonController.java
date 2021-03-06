package com.sfa.web;
import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.TPerson;
import com.sfa.model.TSysUser;
import com.sfa.model.UserAndPerson;
import com.sfa.service.TPersonService;
import com.sfa.service.TSysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/09/12.
*/
@RestController
@RequestMapping("/t/person")
public class TPersonController {
    @Resource
    private TPersonService tPersonService;
    @Resource
    private TSysUserService userserivce;
    @PostMapping("/add")
    public Result add(TPerson tPerson) {
        tPersonService.save(tPerson);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        tPersonService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody UserAndPerson up) {
    	TSysUser user = userserivce.findBy("tUserName", up.user.gettUserName());
    	TPerson person = tPersonService.findBy("tUserId", user.gettUserId());
    	up.person.settPresonId(person.gettPresonId());
    	tPersonService.update(up.getPerson());
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        TPerson tPerson = tPersonService.findById(id);
        return ResultGenerator.genSuccessResult(tPerson);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TPerson> list = tPersonService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
