package com.yznu.shixun.service.impl;

import com.yznu.shixun.domain.Department;
import com.yznu.shixun.domain.Emp;
import com.yznu.shixun.domain.Role;
import com.yznu.shixun.mapper.adminMapper;
import com.yznu.shixun.service.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServiceImpl implements adminService {
    @Autowired
    adminMapper adminMapper;
    @Autowired
    Department department;
    @Autowired
    Role role;

    @Override//部门显示
    public List<Department> showAllDepartment() {
        List<Department> show = adminMapper.showAllDepartment();
        return show;
    }


    /**
     * 部门增加
     *
     * @return
     */
    @Override
    public int addDepartment(Integer department_id, String department_name, String department_self) {
        department.setDepartment_id(department_id);
        department.setDepartment_name(department_name);
        department.setDepartment_self(department_self);
        int add = adminMapper.addDepartment(department);
        return add;
    }

    /**
     * 部门修改
     *
     * @return
     */
    @Override
    public int updateDepartment(Integer department_id, String department_name, String department_self) {
        department.setDepartment_id(department_id);
        department.setDepartment_name(department_name);
        department.setDepartment_self(department_self);
        int update = adminMapper.updateDepartment(department);
        return update;
    }

    /**
     * 部门删除
     *
     * @return
     */
    @Override
    public int deleteDepartment(Integer department_id) {
        adminMapper.deleteDepartment(department_id);
        return 0;
    }

    /**
     * 显示角色信息
     *
     * @return
     */
    @Override
    public List<Role> showAllRole() {
        List<Role> show = adminMapper.showAllRole();
        return show;
    }

    /**
     * 添加角色信息
     *
     * @param role_id
     * @param role_name
     * @return
     */
    @Override
    public int addRole(Integer role_id, String role_name) {
        role.setRole_id(role_id);
        role.setRole_name(role_name);
        int add = adminMapper.addRole(role);
        return add;
    }

    /**
     * 修改角色信息
     *
     * @param role_id
     * @param role_name
     * @return
     */
    @Override
    public int updateRole(Integer role_id, String role_name) {
        role.setRole_id(role_id);
        role.setRole_name(role_name);
        int update = adminMapper.updateRole(role);
        return update;
    }

    /**
     * 删除角色信息
     *
     * @param role_id
     * @return
     */
    @Override
    public int deleteRole(Integer role_id) {
        adminMapper.deleteRole(role_id);
        return 0;
    }

    @Override//根据部门名查询员工
    public List<Emp> findEmpByDepartment_name(String department_name) {
        List<Emp> emp=adminMapper.findEmpByDepartment_name(department_name);
        return emp;
    }
    //根据角色名查询员工
    @Override
    public List<Emp> findEmpByRole_name(String Role_name) {
        List<Emp> emp=adminMapper.findEmpByRole_name(Role_name);
        return emp;
    }



}
