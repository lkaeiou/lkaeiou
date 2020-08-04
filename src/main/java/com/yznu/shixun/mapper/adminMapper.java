package com.yznu.shixun.mapper;

import com.yznu.shixun.domain.Department;
import com.yznu.shixun.domain.Emp;
import com.yznu.shixun.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface adminMapper {
    List<Department> showAllDepartment();   //显示部门信息

    int addDepartment(Department department);    //新增部门信息

    int updateDepartment(Department department); //修改部门信息

    int deleteDepartment(int department_id);     //删除部门信息

    List<Role> showAllRole();//显示角色信息

    Role findDepartmentByRole_id(int role_id); //查询单个角色信息

    int addRole(Role role);    //新增角色信息

    int updateRole(Role role); //修改角色信息

    int deleteRole(int role_id);  //删除角色信息

   List<Emp> findEmpByDepartment_name(String department_name);//根据部门名查询员工

    List<Emp> findEmpByRole_name(String role_name);//根据角色名查询员工


}
