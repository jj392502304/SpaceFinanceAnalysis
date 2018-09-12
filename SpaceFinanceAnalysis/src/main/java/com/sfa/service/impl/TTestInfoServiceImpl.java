package com.sfa.service.impl;

import com.sfa.dao.TTestInfoMapper;
import com.sfa.model.TTestInfo;
import com.sfa.service.TTestInfoService;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/12.
 */
@Service
@Transactional
public class TTestInfoServiceImpl extends AbstractService<TTestInfo> implements TTestInfoService {
    @Resource
    private TTestInfoMapper tTestInfoMapper;

}
