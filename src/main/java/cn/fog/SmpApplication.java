package cn.fog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.fog.mapper")
public class SmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmpApplication.class, args);
	}

}
