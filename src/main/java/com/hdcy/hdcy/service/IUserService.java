package com.hdcy.hdcy.service;

import com.hdcy.hdcy.pojo.User;
import com.hdcy.hdcy.pojo.dto.UserDTO;

public interface IUserService {

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    User add(UserDTO user);
}
