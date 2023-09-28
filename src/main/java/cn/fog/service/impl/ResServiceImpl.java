package cn.fog.service.impl;

import cn.fog.entity.Res;
import cn.fog.mapper.ResMapper;
import cn.fog.service.ResService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ResServiceImpl extends ServiceImpl<ResMapper, Res> implements ResService {
}
