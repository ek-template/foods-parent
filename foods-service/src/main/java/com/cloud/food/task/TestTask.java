package com.cloud.food.task;

import com.cloud.food.service.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in 2020-01-03 18:53
 * @Title TestTask.java
 * <p>Description: [ 定时任务 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Component
@Configuration
@Slf4j
@EnableScheduling
public class TestTask {

    @Autowired
    private IRedisService redisService;

    /**
     * 每10分钟执行一次
     */
    @Scheduled(cron = "0 0/10 * * * ?")
    private void cancelOrderTask() {
        try {
            log.info("#测试，定时任务 每10分钟执行一次");
        } catch (Exception e) {
            log.error("#测试，定时任务 错误 :{}", e);
        }

    }
}
