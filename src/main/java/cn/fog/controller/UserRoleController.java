package cn.fog.controller;

import cn.fog.entity.JsonResult;
import cn.fog.entity.UserRole;
import cn.fog.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userRoles")
public class UserRoleController {
    @Autowired
    private UserRoleService service;

    @PostMapping
    public JsonResult add(@RequestBody UserRole entity){
        boolean save = service.save(entity);
        if(save){
            return JsonResult.ok("保存成功");
        }
        return JsonResult.failure(500,"保存失败");
    }
    @PutMapping
    public JsonResult edit(@RequestBody UserRole entity){
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
    @DeleteMapping("/delByUserId/{id}")
    public JsonResult delByUserId(@PathVariable Long id){

        int deleted = service.deleteByUserId(id);
        return JsonResult.ok("共删除"+deleted+"条数据");
    }
    @DeleteMapping("/delByRoleId/{id}")
    public JsonResult delByRoleId(@PathVariable Long id){

        int deleted = service.deleteByRoleId(id);
        return JsonResult.ok("共删除"+deleted+"条数据");
    }
    @GetMapping("/{id}")
    public JsonResult getById(@PathVariable Long id){
        UserRole entity = service.getById(id);
        return JsonResult.ok(entity);
    }
    @GetMapping("/searchByUserId/{id}")
    public JsonResult getAll(@PathVariable Long id){


        List<UserRole> list = service.search(id);
        return JsonResult.ok(list);

    }

}
