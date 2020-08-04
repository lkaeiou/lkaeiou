package com.yznu.shixun.controller;

import com.yznu.shixun.domain.Emp;
import com.yznu.shixun.domain.Personal;
import com.yznu.shixun.mapper.loginMapper;
import com.yznu.shixun.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/login")
@SessionAttributes("emp")
public class LoginController {
    public static String answer = null;
    public static Integer emp_id = 0;
    @Autowired
    loginMapper loginMapper;
    @Autowired
    loginService loginService;

    //员工登录
    @RequestMapping(value = "/empLogin", method = RequestMethod.GET)
    public String empLogin(@RequestParam("emp_number") Integer emp_number,
                           Model model,
                           @RequestParam("emp_password") String emp_password,
                           HttpSession httpSession,ModelMap model1) {
        if(emp_number==9527&&emp_password.equals("admin")){
            return "admin/index";
        }else {
            Emp emp = loginService.login(emp_number, emp_password);
            try {
                emp_id = emp.getEmp_id();
            } catch (Exception e) {
                model.addAttribute("passwordMisstake", "密码输入错误!");
            }
            if (emp != null ) {
                httpSession.setAttribute("emp", emp);
                model1.addAttribute("emp",emp);
                return "emp/index";
            }
            else if (emp == null) {
                model.addAttribute("passwordMisstake", "密码输入错误!");
                return "login/index";
            }
            return "error/404error";
        }







    }

    //忘记密码,查询出密保问题及答案
    @RequestMapping(value = "/forgetPassword1", method = RequestMethod.GET)
    public String forgetPassword1(@RequestParam("emp_number") Integer emp_number, Model model) {
        if (emp_number != null) {
            Personal personalResult = loginService.forgetPassword1(emp_number);
            emp_id = personalResult.getEmp_id();
            answer = personalResult.getPersonal_secret_answer();
            model.addAttribute("questionAndAnswer", personalResult);
            return "login/forgetPassword2";
        } else return "error/404error";
    }

    //忘记密码,根据密保问题修改密码
    @RequestMapping(value = "/forgetPassword2", method = RequestMethod.GET)
    public String forgetPassword2(@RequestParam("personal_secret_answer") String personal_secret_answer) {
        if (personal_secret_answer != null && personal_secret_answer.equals(answer)) {
            return "login/forgetPassword3";
        } else return "error/404error";
    }

    //忘记密码,根据密保问题修改密码
    @RequestMapping(value = "/forgetPassword3", method = RequestMethod.GET)
    public String forgetPassword3(@RequestParam("newPassword1") String newPassword1, @RequestParam("newPassword2") String newPassword2) {
        if (newPassword1 != null && newPassword2 != null && newPassword1.equals(newPassword2)) {
            int result = loginService.forgetPassword3(newPassword1, emp_id);
            if (result != 0) {
                return "login/index";
            } else return "error/404error";
        } else return "error/404error";
    }

    @RequestMapping("/logout")//员工登出
    public String logout(HttpSession httpSession) {
        httpSession.removeAttribute("emp");
        return "emp/index";
    }


}
