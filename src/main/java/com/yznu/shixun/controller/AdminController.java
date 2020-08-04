package com.yznu.shixun.controller;

import com.yznu.shixun.domain.Department;
import com.yznu.shixun.domain.Emp;
import com.yznu.shixun.domain.Role;
import com.yznu.shixun.mapper.adminMapper;
import com.yznu.shixun.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    adminService adminService;
    @Autowired
    adminMapper adminMapper;

    //显示部门
    @RequestMapping("/showDepartment")
    public String showDepartment(Model model, HttpSession httpSession) {
        List<Department> showDepartment = adminService.showAllDepartment();
        httpSession.setAttribute("showDepartment", showDepartment);
        model.addAttribute("showDepartment", showDepartment);
        return "admin/department";
    }

    //增加部门
    @RequestMapping("/addDepartment")
    public String addDepartment(@RequestParam("department_id") Integer department_id,
                                @RequestParam("department_name") String department_name,
                                @RequestParam("department_self") String department_self) {

        adminService.addDepartment(department_id, department_name, department_self);

        return "redirect:/admin/showDepartment";
    }

    //修改部门
    @RequestMapping("/updateDepartment/{department_id}")
    public String updateDepartment(@PathVariable("department_id") int department_id,
                                   String department_name,
                                   String department_self,
                                   Model model) {
        if (department_name == null && department_self == null) {
            model.addAttribute("department_id", department_id);
            return "admin/departmentUpdate";
        } else {
            adminService.updateDepartment(department_id, department_name, department_self);
            return "redirect:/admin/showDepartment";
        }
    }

    //删除部门
    @RequestMapping("/deleteDepartment/{department_id}")
    public String deleteDepartment(@PathVariable("department_id") int department_id) {
        adminService.deleteDepartment(department_id);
        return "redirect:/admin/showDepartment";
    }

    //显示角色
    @RequestMapping("/showRole")
    public String list(Model model,HttpSession httpSession) {
        List<Role> show = adminService.showAllRole();
        model.addAttribute("showRole", show);
        return "admin/role";
    }

    //增加角色
    @RequestMapping("/addRole")
    public String addRole(@RequestParam("role_id") Integer role_id,
                          @RequestParam("role_name") String role_name) {
        adminService.addRole(role_id, role_name);
        return "redirect:/admin/showRole";
    }


    //修改角色
    @RequestMapping("/updateRole")
    public String updateRole(@RequestParam("role_id") Integer role_id,
                             @RequestParam("role_name") String role_name) {
        adminService.updateRole(role_id, role_name);
        return "redirect:/admin/showRole";
    }

    //删除角色
    @RequestMapping("/deleteRole")
    public String deleteRole(@RequestParam("role_id") int role_id) {
        adminService.deleteRole(role_id);
        return "redirect:/admin/showRole";
    }

//根据部门显示员工
    @RequestMapping("/showAllEmp/{department_name}")
    public String showAllEmp(Model model, Model model2,
                             HttpSession httpSession,
                             @PathVariable("department_name") String department_name) {
        List<Department> department = (List<Department>) httpSession.getAttribute("showDepartment");
        model.addAttribute("department_name", department);
        if (department_name != null) {
            List<Emp> emp = adminService.findEmpByDepartment_name(department_name);
            model2.addAttribute("showAllEmp", emp);
            return "admin/employee";
        }
        return "admin/employee";
    }

    //根据角色名显示员工
    @RequestMapping("/showAllEmpByRole_name/{role_name}")
    public String showAllEmpByRole_name( Model model,Model model2, @PathVariable("role_name") String role_name) {
         List<Role> show = adminService.showAllRole();
         model.addAttribute("showRole", show);
            List<Emp> emp = adminService.findEmpByRole_name(role_name);
            model2.addAttribute("showAllEmpByRole_name", emp);
            return "admin/role";
    }
}
