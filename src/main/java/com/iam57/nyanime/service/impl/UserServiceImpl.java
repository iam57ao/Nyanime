package com.iam57.nyanime.service.impl;

import com.iam57.nyanime.common.constant.UserSexConstant;
import com.iam57.nyanime.common.constant.UserTypeConstant;
import com.iam57.nyanime.common.enumeration.BusinessStatusEnum;
import com.iam57.nyanime.common.exception.NyanimeLoginException;
import com.iam57.nyanime.mapper.UserMapper;
import com.iam57.nyanime.pojo.dto.UserLoginDTO;
import com.iam57.nyanime.pojo.entity.User;
import com.iam57.nyanime.pojo.vo.UserVO;
import com.iam57.nyanime.properties.JWTProperties;
import com.iam57.nyanime.service.UserService;
import com.iam57.nyanime.util.JWTUtil;
import com.iam57.nyanime.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author iam57
 * @since 2024-03-21 08:18:49
 */
@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private JWTProperties jwtProperties;
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

    @Override
    public String login(UserLoginDTO userLoginDTO) {
        String userName = userLoginDTO.getUserName();
        User user = userMapper.getByUserName(userName);
        if (Objects.isNull(user)) {
            log.info("不存在的用户 {} 尝试登录!", userName);
            throw new NyanimeLoginException(BusinessStatusEnum.USER_NOT_EXISTS);
        }
        String rawPassword = userLoginDTO.getPassword();
        String encodedPassword = user.getPassword();
        if (!passwordEncoder.matches(rawPassword, encodedPassword)) {
            log.info("用户 {} 尝试登录,但密码错误!", userName);
            throw new NyanimeLoginException(BusinessStatusEnum.PASSWORD_ERROR);
        }
        log.info("用户 {} 登录成功!", userName);
        Map<String, Object> claim = new HashMap<>();
        claim.put("id", user.getId());
        claim.put("user_type", user.getUserType());
        return JWTUtil.createToken(claim, jwtProperties.getSecret(), jwtProperties.getExpireTime());
    }

    @Override
    public UserVO getById(Integer id) {
        User user = userMapper.getById(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
}
