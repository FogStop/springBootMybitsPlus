package cn.fog.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;
//⾃⾏添加getter、setter、toString()等⽅法
}
