package cn.fog.service.impl;

import cn.fog.entity.User;
import cn.fog.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

public class UserServiceImpl extends ServiceImpl<UserMapper, User>implements IService<User> {

}
