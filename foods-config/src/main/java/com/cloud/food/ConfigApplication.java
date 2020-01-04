package com.cloud.food;

import cn.hutool.core.date.DateUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in 2020-01-04 16:36
 * @Title ConfigApplication.java
 * <p>Description: [ TODO ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:   </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@SpringBootApplication
public class ConfigApplication {

    private static final Log log = LogFactory.get();
    @Value("${qierkang.title:}")
    private String title;

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

    @PostConstruct
    private void init() {
        try {
            log.info("#初始化配置中心 [{}]操作时间[{}]", title, DateUtil.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}