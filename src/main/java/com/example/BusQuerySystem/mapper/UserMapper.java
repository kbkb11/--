package com.example.BusQuerySystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.BusQuerySystem.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}