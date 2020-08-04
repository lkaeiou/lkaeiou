package com.yznu.shixun.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 用户信息
 */
@NoArgsConstructor
@AllArgsConstructor
@Component
@Data
public class Personal {
   private Integer personal_id;//个人ID号
    private Integer emp_id;//员工号ID（外键）
    private String tel_place;//所属区域（外键）
    private String card_name;//名片名称（外键）
    private String message_name;//留言人（外键）
    private String personal_password;//用户密码
    private String personal_sex;//用户性别
    private String personal_age;//用户年龄
    private String personal_department;//所属部门
    private String personal_position;//职位
    private String personal_self;//个人介绍
    private String personal_hobbies;//个人喜好
    private String personal_role;//社会角色
    private String personal_contact;//个人联系方式
    private String personal_secret_question;//密保问题
    private String personal_secret_answer;//密保答案
}

