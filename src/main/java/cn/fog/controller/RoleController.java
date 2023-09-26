package cn.fog.controller;

import cn.fog.dto.RoleDto;
import cn.fog.entity.JsonResult;
import cn.fog.entity.Role;
import cn.fog.service.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService service;

    @PostMapping
    public JsonResult add(@RequestBody Role entity){
        boolean save = service.save(entity);
        if(save){
            return JsonResult.ok("保存成功");
        }
        return JsonResult.failure(500,"保存失败");
    }
    @PutMapping
    public JsonResult edit(@RequestBody Role entity){
       if( entity.getId()==null){
           return JsonResult.failure(400,"你的id不能为空");
       }
        boolean save = service.updateById(entity);
        if(save){
            return JsonResult.ok("修改成功");
        }
        return JsonResult.failure(500,"修改失败");
    }
    @DeleteMapping("/{id}")
    public JsonResult del(@PathVariable Long id){

        boolean b = service.removeById(id);
        if(b){
            return JsonResult.ok("删除"+id+"成功");
        }
        return JsonResult.failure(500,"删除"+id+"成功");
    }
    @GetMapping("/{id}")
    public JsonResult getById(@PathVariable Long id){
        Role entity = service.getById(id);
        return JsonResult.ok(entity);
    }
    @GetMapping
    public JsonResult getAll(@RequestBody RoleDto dto){
        if(dto.getCurrent()==null){
            dto.setCurrent(1);
        }
        if(dto.getPageSize()==null){
            dto.setPageSize(2);
        }
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        boolean hasText = StringUtils.hasText(dto.getName());

        IPage<Role> page = new Page<>(dto.getCurrent(),dto.getPageSize());
        IPage<Role> iPage = service.page(page, queryWrapper);
        return JsonResult.ok(iPage);

    }

}
