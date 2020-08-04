package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用户
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class Emp {
    private Integer emp_id;//员工工号
    private Integer role_id;//角色ID（外键）
    private Integer emp_number;//员工号
    private Integer department_id;//部门ID(外键)
    private String emp_password;//员工密码
    private Personal personalList;
}
