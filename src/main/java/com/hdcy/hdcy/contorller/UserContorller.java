package com.hdcy.hdcy.contorller;


import com.hdcy.hdcy.pojo.ResponseMassage;
import com.hdcy.hdcy.pojo.User;
import com.hdcy.hdcy.pojo.dto.UserDTO;
import com.hdcy.hdcy.service.IUserService;
import jakarta.validation.constraints.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseMassage addUser(@Validated @RequestBody UserDTO user) {
        /**
         * 上方注解的作用是加入数据合法性验证和将传来的json文本转化成对象
         */
        User userNew = userService.add(user);
        return ResponseMassage.success(userNew);
    }

    //查询
    @GetMapping("/{userId}")
    public ResponseMassage findUserById(@PathVariable Integer userId){
        //通过 @PathVariable 可以将 URL中占位符参数绑定到控制器处理方法的入参中
        //URL中的 {xxx} 占位符可以通过@PathVariable(“xxx”) 绑定到操作方法的入参中。
        User userNew = userService.findUserById(userId);
        return ResponseMassage.success(userNew);
    }


    //修改
    @PutMapping
    public ResponseMassage updateUser(@Validated @RequestBody UserDTO user) {
        User userNew = userService.editUser(user);
        return ResponseMassage.success(userNew);
    }

    //删除用户
    @DeleteMapping("/{userId}")
    public ResponseMassage deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseMassage.success(null);
    }
}
