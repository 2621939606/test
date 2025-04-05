package com.hdcy.hdcy.repository;

import com.hdcy.hdcy.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 数据访问层
 */
@Repository     //spring bean
public interface UserRepository extends CrudRepository<User,Integer> { //类和id的属性

    //如何实现自定义的增删改查？
//    <S extends User> User findByUsername(String username);


}
