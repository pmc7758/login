package com.pang.mapper;


import com.pang.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User login(User user);

}
