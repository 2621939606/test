package com.hdcy.hdcy.service;

import com.hdcy.hdcy.pojo.User;
import com.hdcy.hdcy.pojo.dto.UserDTO;

public interface IUserService {

    /**
     * 插入用户
     */
    User add(UserDTO user);

    /**
     * 通过id查询用户
     */
    User findUserById(Integer id);

    /**
     * 修改用户
     */
    User editUser(UserDTO user);

    /**
     * 删除用户
     */
    void deleteUser(Integer userId);
}
