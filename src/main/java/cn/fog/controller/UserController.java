package cn.fog.controller;

import cn.fog.entity.*;
import cn.fog.dto.UserDto;
import cn.fog.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResRoleService resRoleService;
    @Autowired
    private ResService resService;

    @PostMapping("/add")
    public JsonResult add(@RequestBody User user) {
        boolean save = userService.save(user);
        if (save) {
            return JsonResult.ok("保存成功");
        } else {
            return JsonResult.failure(500, "保存失败");
        }
    }

    @PostMapping("/update")
    public JsonResult edit(@RequestBody User user) {
        if (user.getId() == null) {
            return JsonResult.failure(400, "用户ID不可以为空");
        }
        boolean update = userService.updateById(user);
        if (update) {
            return JsonResult.ok("修改成功");
        } else {
            return JsonResult.failure(500, "修改失败");
        }
    }

    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Long id) {
        boolean removeById = userService.removeById(id);
        if (removeById) {
            return JsonResult.ok("删除成功" + id);
        } else {
            return JsonResult.failure(500, "删除失败");
        }
    }

    @GetMapping("/{id}")
    public JsonResult getById(@RequestBody Long id) {
        User user = userService.getById(id);
        return JsonResult.ok(user);
    }

    @GetMapping
    public JsonResult getAll(@RequestBody UserDto userDto) {
        if (userDto.getCurrent() == null) {
            userDto.setCurrent(1);
        }
        if (userDto.getPageSize() == null) {
            userDto.setPageSize(5);
        }
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        hasText传递字符串，不是空就返回true，不然就是false， 先获取如果有就执行userDto.getName()，
//        根据User::getName条件查询userDto.getName()
        queryWrapper.like(StringUtils.hasText(userDto.getName()), User::getName, userDto.getName());
        queryWrapper.eq(userDto.getAge() != null, User::getAge, userDto.getAge());
        queryWrapper.likeLeft(StringUtils.hasText(userDto.getTel()), User::getTel, userDto.getTel());
        IPage<User> page = new Page<>(userDto.getCurrent(), userDto.getPageSize());
        IPage<User> iPage = userService.page(page, queryWrapper);
        return JsonResult.ok(iPage);
    }

    @GetMapping("/searchRoleByUserid/{userId}")
    public JsonResult getAll01(@PathVariable Long userId) {
        List<UserRole> list = userRoleService.search(userId);
        System.out.println(list);
        List<Long> roles = list.stream().map(UserRole::getRoleId).collect(Collectors.toList());//       List<Long> roles = new ArrayList<>();
//        for (UserRole userRole : list) {
//            roles.add(userRole.getRoleId());
//        }

        List<Role> roles1 = roleService.listByIds(roles);
        return JsonResult.ok(roles1);
    }

    @GetMapping("/searchRoleByResId/{userId}")
    public JsonResult getAll02(@PathVariable Long userId) {
        List<UserRole> list = userRoleService.search(userId);
        List<Long> roles = list.stream().map(UserRole::getRoleId).collect(Collectors.toList());
        System.out.println(roles);
//        甄别出来要查询user的role编号id

        LambdaQueryWrapper<ResRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(ResRole::getRoleId,roles);
        List<ResRole> resRoleList = resRoleService.list(queryWrapper);
        System.out.println(resRoleList);
//      筛选ResRole表中符合条件的内容roles

        List<Long> resList = resRoleList.stream().map(ResRole::getResId).collect(Collectors.toList());
        System.out.println(resList);
//        筛选符合ResRole表的res资源id

        List<Res> res = resService.listByIds(resList);
        System.out.println(res);
//        显示res资源内容
        return JsonResult.ok(res);

    }


}
