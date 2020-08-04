package com.yznu.shixun.controller;

import com.yznu.shixun.domain.Metting;

import com.yznu.shixun.mapper.MettingMapper;

import com.yznu.shixun.service.MettingService;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Metting")
public class MettingController {
    @Autowired
    private MettingService mettingService;
    @Autowired
    private MettingMapper mettingMapper;
    //显示会议
    @RequestMapping("/showMetting")
    public String list(Model model) {
        List<Metting> show = mettingService.showAllMetting();
        model.addAttribute("show", show);
        return "admin/mettingIndex";
    }
    //删除预约的会议
    @RequestMapping("/delete/{metting_id}")
    public String deleteMetting(@PathVariable("metting_id") int metting_id) {
        mettingService.deleteMetting(metting_id);
        return "redirect:showMetting";
    }
}
