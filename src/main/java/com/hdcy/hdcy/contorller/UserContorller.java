package com.hdcy.hdcy.contorller;


import com.hdcy.hdcy.pojo.ResponseMassage;
import com.hdcy.hdcy.pojo.User;
import com.hdcy.hdcy.pojo.dto.UserDTO;
import com.hdcy.hdcy.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     //返回对象，并将对象转成json
@RequestMapping("/user")  //类接口的映射 localhost:8080/user
public class UserContorller {

    @Autowired
    IUserService userService;

    //Rest
    //增加
    //@PostMapping("/add")
    //@RequestMapping("/add")
    @PostMapping
    public ResponseMassage<User> addUser(@Validated @RequestBody UserDTO user) {
        /**
         * 上方注解的作用是加入数据合法性验证和将传来的json文本转化成对象
         */
        User userNew = userService.add(user);
        return ResponseMassage.success(userNew);
    }

    //查询


    //修改

    //删除用户
}
