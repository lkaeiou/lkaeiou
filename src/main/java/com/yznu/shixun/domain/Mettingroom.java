package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 会议室
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class Mettingroom {
    private String mettingroom_name;//会议室名称
    private Integer metting_id;//会议室的ID（外键）
    private Integer emp_id;//员工号（外键）
    private String mettingroom_place;//会议室的地点
    private String mettingroom_reserve;//是否被预约
    private String mettingroom_contact;//会议室可容纳人数
    private String mettingroom_air;//是否有空调
}
