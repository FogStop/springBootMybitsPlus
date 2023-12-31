package cn.fog.service.impl;

import cn.fog.entity.User;
import cn.fog.mapper.UserMapper;
import cn.fog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
