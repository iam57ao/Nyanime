package com.iam57.nyanime.util;

import java.util.UUID;

/**
 * @author iam57
 * @since 2024-03-21 14:23:40
 */
public class StringUtil {
    public static String randomString(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }
}
