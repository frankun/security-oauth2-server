package com.frankun.dao;

import com.frankun.dao.base.BaseMapper;
import com.frankun.domain.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2016/10/14
 *
 * @author frankun
 */
public interface UserMapper extends BaseMapper{

    User findByGuid(String guid);

    void saveUser(User user);

    void updateUser(User user);

    User findByUsername(String username);

    List<User> searchUserByUsername(@Param("username") String username);
}
