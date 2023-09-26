package cn.fog.service;

import cn.fog.entity.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;


public interface UserRoleService extends IService<UserRole> {
    int deleteByUserId(Long userId);
    int deleteByRoleId(Long roleId);
    List<UserRole> search(Serializable id);
}
