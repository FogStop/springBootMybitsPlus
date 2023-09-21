package cn.fog.controller;

import cn.fog.common.JsonResult;
import cn.fog.entity.User;
import cn.fog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public JsonResult add(@RequestBody User user){
        boolean save = userService.save(user);
        if (save){
            return JsonResult.ok("保存成功");
        }else {
            return JsonResult.failure(500,"保存失败");
        }
    }

    @PostMapping("/update")
    public JsonResult edit(@RequestBody User user){
        if (user.getId()==null){
            return JsonResult.failure(400,"用户ID不可以为空");
        }
        boolean update = userService.updateById(user);
        if (update){
            return JsonResult.ok("修改成功");
        }else {
            return JsonResult.failure(500,"修改失败");
        }
    }

    @PostMapping("/{id}")
    public JsonResult delete(@PathVariable Long id){
        boolean removeById = userService.removeById(id);
        if (removeById){
            return JsonResult.ok("删除成功"+id);
        }else {
            return JsonResult.failure(500,"删除失败");
        }
    }
}
