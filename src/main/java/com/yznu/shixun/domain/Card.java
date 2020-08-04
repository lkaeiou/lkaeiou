package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 *个人名片
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class Card {
    private String card_name;//名片名称
    private Integer personal_id;//员工ID号（外键）
    private String card_type;//名片类别
}
