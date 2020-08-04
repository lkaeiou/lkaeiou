package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 通讯录
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class Tel {
    private String tel_place;//销售片区
}
