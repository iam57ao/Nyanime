package com.iam57.nyanime.controller.user;

import com.auth0.jwt.interfaces.Claim;
import com.iam57.nyanime.pojo.dto.UserLoginDTO;
import com.iam57.nyanime.pojo.vo.UserVO;
import com.iam57.nyanime.service.UserService;
import com.iam57.nyanime.util.JWTUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author iam57
 * @since 2024-03-22 08:58:58
 */
@Tag(name = "用户相关接口")
@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private JWTUtil jwtUtil;

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.login(userLoginDTO);
    }

    @Operation(summary = "个人信息")
    @GetMapping
    public UserVO info() {
        Map<String, Claim> claims = jwtUtil.getClaims();
        Integer id = claims.get("id").asInt();
        return userService.getById(id);
    }
}
