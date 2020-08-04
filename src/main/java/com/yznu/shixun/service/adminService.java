package com.yznu.shixun.service;

import com.yznu.shixun.domain.Department;
import com.yznu.shixun.domain.Emp;
import com.yznu.shixun.domain.Role;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface adminService {

    List<Department> showAllDepartment();

    int addDepartment(Integer department_id, String department_name, String department_self);

    int updateDepartment(Integer department_id, String department_name, String department_self);

    int deleteDepartment(Integer department_id);

    List<Role> showAllRole();

    int addRole(Integer role_id, String role_name);

    int updateRole(Integer role_id, String role_name);

    int deleteRole(Integer role_id);

    List<Emp> findEmpByDepartment_name(String department_name);//根据部门名查询员工

    List<Emp> findEmpByRole_name(String Role_name);//根据角色名查询员工


}
