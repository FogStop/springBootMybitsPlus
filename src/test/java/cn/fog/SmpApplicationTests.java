package cn.fog;

import cn.fog.entity.User;
import cn.fog.mapper.UserMapper;
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

}
