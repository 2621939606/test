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

    @Override
    public User findUserById(Integer id) {
        //加了用户不存在的异常处理，如果传入非法数据或者没有查到用户则抛出异常信息
        //IllegalArgumentException是参数不合法异常
        return userRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在，参数异常！");
        });
    }

    @Override
    public User editUser(UserDTO user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user,userPojo);
        //保存和修改都是调用save
        return userRepository.save(userPojo);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

}
