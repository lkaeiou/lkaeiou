package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 留言类
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class Message {
    private Integer message_id;//留言号
    private Integer personal_id;//用户ID
    private Integer emp_id;//用户ID
    private String message_name;//留言人
    private Date message_time;//留言时间
    private String message_content;//留言内容

}

