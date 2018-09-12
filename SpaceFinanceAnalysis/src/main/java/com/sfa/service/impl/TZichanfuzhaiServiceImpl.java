package com.sfa.service.impl;

import com.sfa.dao.TZichanfuzhaiMapper;
import com.sfa.model.TZichanfuzhai;
import com.sfa.service.TZichanfuzhaiService;
import com.sfa.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/12.
 */
@Service
@Transactional
public class TZichanfuzhaiServiceImpl extends AbstractService<TZichanfuzhai> implements TZichanfuzhaiService {
    @Resource
    private TZichanfuzhaiMapper tZichanfuzhaiMapper;

}
