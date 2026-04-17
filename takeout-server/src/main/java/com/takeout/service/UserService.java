package com.takeout.service;

import com.takeout.dto.UserLoginDTO;
import com.takeout.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {


    /**
     * 微信登录
     * @param userLoginDTO
     * @return
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
