package com.hdcy.hdcy.service;


import com.hdcy.hdcy.pojo.User;
import com.hdcy.hdcy.pojo.dto.UserDTO;
import com.hdcy.hdcy.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service        // spring的bean
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User add(UserDTO user) {

        //因为数据访问层的类是User不能传入userDTO类型的user变量，所以要将user里面的数据复制到userPojo
        User userPojo = new User();
        BeanUtils.copyProperties(user,userPojo);

        return userRepository.save(userPojo);
    }

}
