/*
 * @(#)con.cloud.food 2020-01-04 14:48
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package food;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ TODO ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:   </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
public class TestModelController extends BaseJunitTestModel {


    @Test
    public void test() {
        String result = restTemplate.getForObject("http://foods-service/v1/service/hello?name=RestTemplate调用实现", String.class);
//        String result = testService.hello("FeignClient调用实现");
        System.out.println(JSON.toJSONString(result));
    }
}
