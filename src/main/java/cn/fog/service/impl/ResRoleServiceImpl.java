package cn.fog.service.impl;

import cn.fog.entity.ResRole;
import cn.fog.mapper.ResRoleMapper;
import cn.fog.service.ResRoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


@Service
public class ResRoleServiceImpl extends ServiceImpl<ResRoleMapper, ResRole> implements ResRoleService {
    @Autowired
    private ResRoleMapper mapper;
    @Override
    public int deleteByResId(Long userId) {
        LambdaQueryWrapper<ResRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ResRole::getRoleId,userId);
        int deleted = mapper.delete(queryWrapper);

        return deleted;
    }

    @Override
    public int deleteByRoleId(Long roleId) {
        LambdaQueryWrapper<ResRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ResRole::getRoleId,roleId);
        int deleted = mapper.delete(queryWrapper);

        return deleted;
    }

    @Override
    public List<ResRole> search(Serializable id) {
        LambdaQueryWrapper<ResRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(id!=null,ResRole::getResId,id);
        return mapper.selectList(queryWrapper);
    }
}
