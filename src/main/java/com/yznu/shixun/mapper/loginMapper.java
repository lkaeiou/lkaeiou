package com.yznu.shixun.mapper;


import com.yznu.shixun.domain.Emp;
import com.yznu.shixun.domain.Personal;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface loginMapper {
    Emp login(Emp emp);  //员工登录

    Personal forgetPassword1(Integer emp_number);//忘记密码,查询出密保问题及答案

    int forgetPassword3(Emp emp);
}

