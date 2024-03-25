package com.iam57.nyanime.service;

import com.iam57.nyanime.pojo.dto.UserLoginDTO;

/**
 * @author iam57
 * @since 2024-03-21 08:10:50
 */
public interface UserService {
    boolean initSuperAdminUser();
    String login(UserLoginDTO userLoginDTO);
}
