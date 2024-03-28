package com.iam57.nyanime.interceptor;

import com.alibaba.fastjson2.JSON;
import com.iam57.nyanime.common.enumeration.BusinessStatusEnum;
import com.iam57.nyanime.common.exception.NyanimeLoginException;
import com.iam57.nyanime.common.result.HttpResult;
import com.iam57.nyanime.properties.JWTProperties;
import com.iam57.nyanime.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;

/**
 * @author iam57
 * @since 2024-03-26 10:13:36
 */
@Component
@AllArgsConstructor
public class JWTInterceptor implements HandlerInterceptor {
    private JWTProperties jwtProperties;
    private JWTUtil jwtUtil;

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        String authHeader = request.getHeader(jwtProperties.getHeader());
        if (Objects.isNull(authHeader) || !jwtUtil.parseJWT(authHeader)) {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(JSON.toJSONString(HttpResult.error(new NyanimeLoginException(BusinessStatusEnum.USER_NOT_LOGGED_IN))));
            return false;
        }
        return true;
    }
}
