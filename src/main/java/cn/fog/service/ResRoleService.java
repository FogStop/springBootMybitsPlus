package cn.fog.service;

import cn.fog.entity.ResRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

public interface ResRoleService extends IService<ResRole> {
    int deleteByResId(Long userId);
    int deleteByRoleId(Long roleId);
    List<ResRole> search(Serializable id);
}
