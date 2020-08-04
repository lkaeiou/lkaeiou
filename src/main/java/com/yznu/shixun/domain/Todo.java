package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 待办事项
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class Todo {
    private Integer untreated_id;//未处理事件的ID
    private Integer emp_id;//员工号
    private String untreated_work;//未处理工作
    private String untreated_message;//为处理留言
}
