package com.yznu.shixun.controller;

import com.yznu.shixun.domain.Personal;
import com.yznu.shixun.service.mailListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class mailListController {
    @Autowired
    private mailListService mailListService;
    @Autowired
    private List<Personal> personal;
    @Autowired
    private Personal personal1;
    @RequestMapping("/mailselect")//通讯录显示
    public String tongxunlu(Model model){
        personal=mailListService.mailSelect();
        model.addAttribute("personal",personal);
        return "emp/mailList";
    }
   @RequestMapping("/mailsearch")//通讯录查找
    public String chazhao(@RequestParam("personid") int id,Model model){
        personal1=mailListService.mailsearch1(id);
        if(personal1==null){
            return "error/error";
        }
        model.addAttribute("person",personal1);
        return "emp/mailListSearch";
   }
}
