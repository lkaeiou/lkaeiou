package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 预约会议
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class Metting {
    private Integer metting_id;//预约会议的ID号
    private Integer emp_id;//预约会议的人的员工号ID
    private String metting_room;//预约会议的地点
    private Date metting_time;//预约会议的时间
    private String metting_leader;//会议的主持人
}
