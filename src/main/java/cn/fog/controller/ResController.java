package cn.fog.controller;

import cn.fog.dto.ResDto;
import cn.fog.entity.JsonResult;
import cn.fog.entity.Res;
import cn.fog.service.ResService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/res")
public class ResController {
    @Autowired
    private ResService service;

    @PostMapping
    public JsonResult add(@RequestBody Res entity){
        boolean save = service.save(entity);
        if(save){
            return JsonResult.ok("保存成功");
        }
        return JsonResult.failure(500,"保存失败");
    }
    @PutMapping
    public JsonResult edit(@RequestBody Res entity){
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
        Res entity = service.getById(id);
        return JsonResult.ok(entity);
    }
    @GetMapping
    public JsonResult getAll(@RequestBody ResDto dto){
        if(dto.getCurrent()==null){
            dto.setCurrent(1);
        }
        if(dto.getPageSize()==null){
            dto.setPageSize(2);
        }
        LambdaQueryWrapper<Res> queryWrapper = new LambdaQueryWrapper<>();
        boolean hasText = StringUtils.hasText(dto.getName());

        IPage<Res> page = new Page<>(dto.getCurrent(),dto.getPageSize());
        IPage<Res> iPage = service.page(page, queryWrapper);
        return JsonResult.ok(iPage);

    }
}
