package cn.fog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    //雪花算法生成id
    private Long id;
    private String name;
    private String password;
    private Integer age;
    @TableField(value = "tel")
    private String tel;
//⾃⾏添加getter、setter、toString()等⽅法
}
