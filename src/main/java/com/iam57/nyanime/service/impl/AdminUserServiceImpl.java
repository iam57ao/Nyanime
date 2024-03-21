package com.iam57.nyanime.service.impl;

import com.iam57.nyanime.common.constant.UserSexConstant;
import com.iam57.nyanime.common.constant.UserTypeConstant;
import com.iam57.nyanime.mapper.UserMapper;
import com.iam57.nyanime.pojo.entity.User;
import com.iam57.nyanime.service.AdminUserService;
import com.iam57.nyanime.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author iam57
 * @since 2024-03-21 08:18:49
 */
@Slf4j
@Service
@AllArgsConstructor
public class AdminUserServiceImpl implements AdminUserService {
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

    @Override
    public boolean initSuperAdminUser() {
        // 判断超级管理员是否以及存在
        Integer superAdminCount = userMapper.countByUserType(UserTypeConstant.SUPER_ADMIN);
        if (superAdminCount > 0) {
            return false;
        }
        //创建管理员账号
        log.info("超级管理员用户不存在, 正在创建...");
        String userName = StringUtil.randomString(5);
        String rawPassword = StringUtil.randomString(16);
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User user = User.builder()
                .userName(userName)
                .password(encodedPassword)
                .sex(UserSexConstant.OTHER)
                .userType(UserTypeConstant.SUPER_ADMIN)
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        userMapper.insert(user);
        log.info("用户名: {}", userName);
        log.info("密码: {}", rawPassword);
        return true;
    }
}
