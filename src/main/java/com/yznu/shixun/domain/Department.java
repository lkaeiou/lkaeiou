package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 部门
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class Department {
    private Integer department_id;//部门ID号
    private String department_name;//部门名称
    private String department_self;//部门介绍
}
