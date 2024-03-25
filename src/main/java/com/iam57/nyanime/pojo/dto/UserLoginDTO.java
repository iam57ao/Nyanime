package com.iam57.nyanime.pojo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author iam57
 * @since 2024-03-22 09:03:44
 */
@Data
public class UserLoginDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -8347793086755895612L;
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
}
