package com.iam57.nyanime.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author iam57
 * @since 2024-03-19 20:54:10
 */
@Getter
@AllArgsConstructor
public enum BusinessStatusEnum {
    SUCCESS(0, "成功!"),
    ERROR(-1, "未知错误!");
    private final Integer code;
    private final String message;
}
