package com.iam57.nyanime.controller.user;

import com.iam57.nyanime.pojo.dto.UserLoginDTO;
import com.iam57.nyanime.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author iam57
 * @since 2024-03-22 08:58:58
 */
@Tag(name = "用户相关接口")
@Slf4j
@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public String login(UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }
}
