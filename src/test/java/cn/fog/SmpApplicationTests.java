package cn.fog;

import cn.fog.entity.User;
import cn.fog.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SmpApplicationTests {
	@Autowired
	UserMapper userMapper;
	@Test
	void contextLoads01() {
		User user = new User();
		user.setId(8L);
		user.setAge(18);
		user.setName("张三");
		user.setPassword("123456");
		userMapper.updateById(user);
		System.out.println(user);
	}
	@Test
	void contextLoads02() {
		List<User> users = userMapper.selectList(null);
		System.out.println(users);
	}
	@Test
	void contextLoads03(){
//		1.QueryWrapper条件构造器，gt意思是大于，这个几乎万能
//		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//		queryWrapper.gt("age",15);
//		List<User> list = userMapper.selectList(queryWrapper);
//		System.out.println(list);
//		2.系统有提示的构造器
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.gt(User::getAge,15);
		queryWrapper.eq(User::getName,"张益达");
		List<User> list = userMapper.selectList(queryWrapper);
		System.out.println(list+"大于和等于");

		queryWrapper.ge(User::getAge,18);
		List<User> list01 = userMapper.selectList(queryWrapper);
		System.out.println(list01+">=");

		queryWrapper.lt(User::getAge,15);
		queryWrapper.between(User::getAge,15,0);
		List<User> list02 = userMapper.selectList(queryWrapper);
		System.out.println(list02+"<和两者之间");

		queryWrapper.le(User::getAge,20);
		queryWrapper.notBetween(User::getAge,16,18);
		List<User> list03 = userMapper.selectList(queryWrapper);
		System.out.println(list03+"<=20且不在16与18");
	}
	@Test
	void contextLoads04(){
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.like(User::getAge,8);
		List<User> list = userMapper.selectList(queryWrapper);
		System.out.println(list+"Like");

		queryWrapper.notLike(User::getName,"张");
		List<User> list01 = userMapper.selectList(queryWrapper);
		System.out.println(list01+"notLike");

		queryWrapper.likeRight(User::getAge,8);
		List<User> list02 = userMapper.selectList(queryWrapper);
		System.out.println(list02+"LikeRight");

		queryWrapper.notLikeRight(User::getName,"张大炮");
		List<User> list03 = userMapper.selectList(queryWrapper);
		System.out.println(list03+"notLikeRight");


	}

	@Test
	void contextLoads05(){
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

		queryWrapper.notLikeLeft(User::getName,"张益达");
		List<User> list01 = userMapper.selectList(queryWrapper);
		System.out.println(list01+"notLikeLeft");

		queryWrapper.isNotNull(User::getId);
		List<User> list02 = userMapper.selectList(queryWrapper);
		System.out.println(list02+"isNotNULL值");

		queryWrapper.isNull(User::getId);
		List<User> list03 = userMapper.selectList(queryWrapper);
		System.out.println(list03+"isNULL值");
	}

	@Test
	void contextLoads06(){
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

		queryWrapper.in(User::getAge,8,28);
		List<User> list = userMapper.selectList(queryWrapper);
		System.out.println(list+"in  包含里面的字段内容");

		queryWrapper.inSql(User::getAge,"select age from user where age < 28");
		List<User> list01 = userMapper.selectList(queryWrapper);
		System.out.println(list01+"InSql 在里面写sql语句 同样也有notInSql");

/**
 * 还有groupBy、orderByAsc、orderByDesc、having、func、or
 */

	}

}
