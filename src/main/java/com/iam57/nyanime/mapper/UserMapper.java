package com.iam57.nyanime.mapper;

import com.iam57.nyanime.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author iam57
 * @since 2024-03-21 08:34:47
 */
@Mapper
public interface UserMapper {
    Integer countByUserType(Integer userType);

    void insert(User user);

    User getByUserName(String userName);

    User getById(Integer id);
}
