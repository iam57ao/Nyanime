package com.iam57.nyanime.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author iam57
 * @since 2024-03-18 20:26:23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 4278176330966428633L;
    private Integer id;
    private Integer sex;
    private Integer userType;
    private String username;
    private String password;
    private String avatar;
    private String email;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
