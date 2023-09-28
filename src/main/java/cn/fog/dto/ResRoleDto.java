package cn.fog.dto;

import lombok.Data;

@Data
public class ResRoleDto extends PageDto {
    private Long id;
    private Long roleId;
    private Long resId;
}
