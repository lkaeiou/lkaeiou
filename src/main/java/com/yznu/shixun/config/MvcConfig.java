package com.yznu.shixun.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login/index");
        registry.addViewController("/forgetPassword1").setViewName("login/forgetPassword1");
        registry.addViewController("/forgetPassword2").setViewName("login/forgetPassword2");
        registry.addViewController("/forgetPassword3").setViewName("login/forgetPassword3");

        registry.addViewController("/adminpublic").setViewName("admin/public");
        registry.addViewController("/admin").setViewName("admin/index");

        registry.addViewController("/department").setViewName("admin/department");
        registry.addViewController("/departmentUpdate").setViewName("admin/departmentUpdate");
        registry.addViewController("/departmentDelete").setViewName("admin/departmentAdd");

        registry.addViewController("/role").setViewName("admin/role");
        registry.addViewController("/roleUpdate").setViewName("admin/roleUpdate");
        registry.addViewController("/roleAdd").setViewName("admin/roleAdd");
        registry.addViewController("/roleDelete").setViewName("admin/roleDelete");

        registry.addViewController("/emp").setViewName("admin/employee");
    }
}
