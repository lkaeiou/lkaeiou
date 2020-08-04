package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 角色
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class Role {
    private Integer role_id;//角色ID
    private String role_name;//角色名
}
