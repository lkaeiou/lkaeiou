package com.yznu.shixun.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class message_read {
    int id;
    int emp_id;
    int message_id;
    int delete_flag;
    int read_flag;
}
