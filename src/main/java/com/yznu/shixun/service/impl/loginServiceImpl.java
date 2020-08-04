package com.yznu.shixun.service.impl;

import com.yznu.shixun.domain.Emp;
import com.yznu.shixun.domain.Personal;
import com.yznu.shixun.mapper.loginMapper;
import com.yznu.shixun.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class loginServiceImpl implements loginService {
    @Autowired
    loginMapper loginMapper;
    @Autowired
    Emp emp;
    @Autowired
    Personal personal;

    @Override//员工登录
    public Emp login(Integer emp_number, String emp_password) {
        emp.setEmp_number(emp_number);
        emp.setEmp_password(emp_password);
        Emp empResult = loginMapper.login(emp);
        return empResult;
    }

    @Override//忘记密码,查询出密保问题及答案
    public Personal forgetPassword1(Integer emp_number) {
        Personal personalResult = loginMapper.forgetPassword1(emp_number);
        return personalResult;
    }

    @Override//忘记密码,修改密码
    public int forgetPassword3(String newpassword, Integer emp_id) {
        emp.setEmp_id(emp_id);
        emp.setEmp_password(newpassword);
        int s=loginMapper.forgetPassword3(emp);
        System.out.println(s);
        return s;
    }
}
