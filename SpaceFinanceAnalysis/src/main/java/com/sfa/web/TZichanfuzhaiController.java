package com.sfa.web;
import com.sfa.core.Result;
import com.sfa.core.ResultGenerator;
import com.sfa.model.TZichanfuzhai;
import com.sfa.service.TZichanfuzhaiService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/09/12.
*/
@RestController
@RequestMapping("/t/zichanfuzhai")
public class TZichanfuzhaiController {
    @Resource
    private TZichanfuzhaiService tZichanfuzhaiService;

    @PostMapping("/add")
    public Result add(TZichanfuzhai tZichanfuzhai) {
        tZichanfuzhaiService.save(tZichanfuzhai);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam String id) {
        tZichanfuzhaiService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(TZichanfuzhai tZichanfuzhai) {
        tZichanfuzhaiService.update(tZichanfuzhai);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam String id) {
        TZichanfuzhai tZichanfuzhai = tZichanfuzhaiService.findById(id);
        return ResultGenerator.genSuccessResult(tZichanfuzhai);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<TZichanfuzhai> list = tZichanfuzhaiService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
