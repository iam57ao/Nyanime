package com.iam57.nyanime.common.exception;

import com.iam57.nyanime.common.enumeration.BusinessStatusEnum;

import java.io.Serial;

/**
 * @author iam57
 * @since 2024-03-25 09:10:30
 */
public class NyanimeLoginException extends NyanimeException {
    public NyanimeLoginException(BusinessStatusEnum businessStatusEnum) {
        super(businessStatusEnum);
    }

    @Serial
    private static final long serialVersionUID = 3119564946849638665L;
}
