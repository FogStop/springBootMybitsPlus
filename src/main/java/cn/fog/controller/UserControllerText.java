package cn.fog.controller;

import cn.fog.entity.User;
import cn.fog.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserControllerText {
    @Resource
    private UserMapper userMapper;

    @PostMapping("/query")
    public List<User> getUser(User user){
        log.info("空值NULL");
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        if(user.getAge()!=null){
//            queryWrapper.gt(User::getAge,user.getAge());
//        }上下等价
        queryWrapper.gt(user.getAge()!=null,User::getAge,user.getAge());
        queryWrapper.eq(user.getName()!=null,User::getName,user.getName());
//        if (user.getName()!=null){
//            queryWrapper.like(User::getName,user.getName());
//        }上下等价条件内的嵌套
        List<User> list = userMapper.selectList(queryWrapper);
        return list;
    }

    @PostMapping("/page")
    public List<User> getPage(){
        log.info("分页，不完整版");
        Page<User> page = new Page<>(1,3);
        userMapper.selectPage(page,null);
        System.out.println("当前⻚码值："+page.getCurrent());
        System.out.println("每⻚显示数："+page.getSize());
        System.out.println("总⻚数："+page.getPages());
        System.out.println("总条数："+page.getTotal());
        System.out.println("当前⻚数据："+page.getRecords());
        return page.getRecords();
    }

    @PostMapping("/seclet")
    public List<User> getList(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("count(*) as count, tel");
        queryWrapper.groupBy("tel");
        List<Map<String, Object>> Userlist = userMapper.selectMaps(queryWrapper);
        System.out.println(Userlist);
        return null;
    }

    @PostMapping("/user01")
    public List<User> getUser01(){
        User user = new User();
        user.setTel("0");
        user.setAge(19);
        user.setName("张三");
        userMapper.insert(user);

        return null;
    }

    @PostMapping("/page01")
    public IPage<User> getPage(User user, Integer current, Integer pageSize) {
        if (current==null){
            current=1;
        }
        if (pageSize==null){
            pageSize=3;
        }
        IPage<User> page = new Page<>(current,pageSize);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.gt(user.getAge()!=null,User::getAge,user.getAge());
        queryWrapper.eq(user.getName()!=null,User::getName,user.getName());

        IPage<User> userIPage = userMapper.selectPage(page, queryWrapper);
        return userIPage;
    }
}
