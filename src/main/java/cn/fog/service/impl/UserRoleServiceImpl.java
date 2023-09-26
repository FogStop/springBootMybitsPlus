package cn.fog.service.impl;


import cn.fog.entity.UserRole;
import cn.fog.mapper.UserRoleMapper;
import cn.fog.service.UserRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {
    @Autowired
    private UserRoleMapper mapper;
    @Override
    public int deleteByUserId(Long userId) {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserRole::getRoleId,userId);
        int deleted = mapper.delete(queryWrapper);

        return deleted;
    }

    @Override
    public int deleteByRoleId(Long roleId) {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserRole::getRoleId,roleId);
        int deleted = mapper.delete(queryWrapper);

        return deleted;
    }

    @Override
    public List<UserRole> search(Serializable id) {
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(id!=null,UserRole::getUserId,id);
       return mapper.selectList(queryWrapper);
    }
}
