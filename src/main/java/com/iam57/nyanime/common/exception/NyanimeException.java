package com.iam57.nyanime.common.exception;

import com.iam57.nyanime.common.enumeration.BusinessStatusEnum;
import lombok.Getter;

import java.io.Serial;

/**
 * @author iam57
 * @since 2024-03-20 10:46:33
 */
@Getter
public class NyanimeException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -8340014787265394772L;

    private final BusinessStatusEnum businessStatusEnum;

    public NyanimeException(BusinessStatusEnum businessStatusEnum) {
        this.businessStatusEnum = businessStatusEnum;
    }

    public NyanimeException() {
        this(BusinessStatusEnum.ERROR);
    }
}
