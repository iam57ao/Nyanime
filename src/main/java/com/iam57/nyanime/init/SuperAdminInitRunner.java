package com.iam57.nyanime.init;

import com.iam57.nyanime.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author iam57
 * @since 2024-03-21 08:07:04
 */
@Slf4j
@Component
@AllArgsConstructor
public class SuperAdminInitRunner implements ApplicationRunner {
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) {
        if (userService.initSuperAdminUser()) {
            log.info("初始化超级管理员账号完成!");
        }
    }
}
