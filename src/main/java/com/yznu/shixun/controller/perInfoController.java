package com.yznu.shixun.controller;

import com.yznu.shixun.domain.Emp;
import com.yznu.shixun.domain.Personal;
import com.yznu.shixun.service.perInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class perInfoController {
    @Autowired
    private perInfoService perInfoService;
    @Autowired
    private Personal personal;
    String msg1="";
    @RequestMapping("/selectper")//显示个人信息
    public String chaxungerenxingxi( Model model, HttpSession httpSession)//显示个人信息
    {
       Emp emp=(Emp)httpSession.getAttribute("emp");
       int id=emp.getEmp_id();
       personal=perInfoService.personInfomation(id);
       model.addAttribute("personal",personal);
        return "emp/personInfo";
    }
    @RequestMapping("/updateper")//更改个人信息
    public String gengxin(Personal personal,HttpSession httpSession,Model model)
    {
        int flag=perInfoService.updatePerInfomation(personal);
        if(flag==0)
        {
            msg1="插入失败";
            model.addAttribute("msg1",msg1);
            return  "error/404error";
        }
        msg1="修改成功";
        model.addAttribute("msg1",msg1);
        model.addAttribute("personal",personal);
        return "emp/personInfo";
    }
}
