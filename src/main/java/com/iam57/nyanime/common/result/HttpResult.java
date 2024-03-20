package com.iam57.nyanime.common.result;

import com.iam57.nyanime.common.enumeration.BusinessStatusEnum;
import com.iam57.nyanime.common.exception.NyanimeException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author iam57
 * @since 2024-03-19 20:49:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResult<T> {
    private Integer code;
    private String message;
    private T data;

    public static HttpResult<Void> success() {
        return new HttpResult<>(BusinessStatusEnum.SUCCESS.getCode(), BusinessStatusEnum.SUCCESS.getMessage(), null);
    }

    public static <T> HttpResult<T> success(T data) {
        return new HttpResult<>(BusinessStatusEnum.SUCCESS.getCode(), BusinessStatusEnum.SUCCESS.getMessage(), data);
    }

    public static HttpResult<Void> error() {
        return new HttpResult<>(BusinessStatusEnum.ERROR.getCode(), BusinessStatusEnum.ERROR.getMessage(), null);
    }

    public static HttpResult<Void> error(NyanimeException exception) {
        return new HttpResult<>(exception.getBusinessStatusEnum().getCode(), exception.getBusinessStatusEnum().getMessage(), null);
    }
}
