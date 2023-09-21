package cn.fog.dto;

import lombok.Data;

@Data
public class UserDto extends PageDto{
    private String name;
    private String tel;
    private Integer age;
}
