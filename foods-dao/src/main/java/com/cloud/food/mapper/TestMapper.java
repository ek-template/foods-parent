/*
 * @(#)com.cloud.food.mapper 2020-01-05 00:49
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.food.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.food.model.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ TODO ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Mapper
public interface TestMapper extends BaseMapper<TestModel> {

    String columns = "id,banner_name,banner_describe,banner_start,banner_end,condition_type,page_type,banner_path,page_path,status,create_time,update_time,sort";

    @Select("SELECT " + columns + " FROM test_model")
    List<TestModel> getTestList();
}
