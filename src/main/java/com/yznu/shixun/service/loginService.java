package com.yznu.shixun.service;

import com.yznu.shixun.domain.Emp;

import com.yznu.shixun.domain.Personal;
import org.springframework.stereotype.Service;

@Service
public interface loginService {
    Emp login(Integer emp_number, String emp_password);//员工登录

    Personal forgetPassword1(Integer emp_number);//忘记密码,查询出密保问题及答案
    int forgetPassword3(String newpassword,Integer emp_id);
}
