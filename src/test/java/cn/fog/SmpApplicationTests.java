package cn.fog;

import cn.fog.entity.User;
import cn.fog.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.function.Consumer;

@SpringBootTest
@Slf4j
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

/*
  还有groupBy、orderByAsc、orderByDesc、having、func、or,isNotNull
  and,nested,apply,last,exists,notExists
 */
	}

	@Test
	void contextLoads07(){
		log.info("多种条件01");
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

		queryWrapper.gt(User::getAge,16);
		queryWrapper.or(query->{
			query.eq(User::getName,"tom");
			query.eq(User::getId,1);
		});
		queryWrapper.eq(User::getName,"tom");
		List<User> list = userMapper.selectList(queryWrapper);
		System.out.println(list);
	}

	/**
	 * 07，08上下等价
	 */
	@Test
	void contextLoads08(){
		log.info("多种条件02");
		LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

		queryWrapper.gt(User::getAge,16);
		queryWrapper.or(new Consumer<LambdaQueryWrapper<User>>() {
			@Override
			public void accept(LambdaQueryWrapper<User> userLambdaQueryWrapper) {
				userLambdaQueryWrapper.eq(User::getName,"tom");
				userLambdaQueryWrapper.eq(User::getId,1);
			}
		});

		List<User> list = userMapper.selectList(queryWrapper);
		System.out.println(list);
	}
	//分⻚查询
	@Test
	void testSelectPage(){
//1 创建IPage分⻚对象,设置分⻚参数
		IPage<User> page=new Page<>(1,3);
//2 执⾏分⻚查询
		userMapper.selectPage(page,null);
//3 获取分⻚结果
		System.out.println("当前⻚码值："+page.getCurrent());
		System.out.println("每⻚显示数："+page.getSize());
		System.out.println("总⻚数："+page.getPages());
		System.out.println("总条数："+page.getTotal());
		System.out.println("当前⻚数据："+page.getRecords());
	}

}
