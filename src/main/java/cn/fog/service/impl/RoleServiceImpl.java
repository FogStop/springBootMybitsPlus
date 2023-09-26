package cn.fog.service.impl;


import cn.fog.entity.Role;
import cn.fog.mapper.RoleMapper;
import cn.fog.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
}
