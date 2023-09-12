package cn.fog;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("cn.fog.mapper")
public class SmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmpApplication.class, args);
		log.info("项目启动成功");
	}

}
