/*
 * @(#)com.cloud.food.service.impl 2020-01-05 00:27
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.food.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.food.mapper.TestMapper;
import com.cloud.food.model.TestModel;
import com.cloud.food.result.BaseResponse;
import com.cloud.food.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ 测试服务类 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:   </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, TestModel> implements ITestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public BaseResponse getList() {
        List<TestModel> testModels = testMapper.selectList(new QueryWrapper<>());
        return BaseResponse.success(testModels);
    }


}
