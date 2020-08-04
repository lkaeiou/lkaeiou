package com.yznu.shixun.controller;


import com.yznu.shixun.domain.Mettingroom;
import com.yznu.shixun.mapper.MettingRoomMapper;
import com.yznu.shixun.service.MettingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/MettingRoom")
public class MettingRoomController {
    @Autowired
    MettingRoomService mettingRoomService;
    @Autowired
    MettingRoomMapper mettingRoomMapper;

    //显示会议室
    @RequestMapping("/showMettingRoom")
    public String list(Model model) {
        List<Mettingroom> show = mettingRoomService.showAllMettingRoom();
        model.addAttribute("show", show);
        return "admin/mettingRoomIndex";
    }

    //修改预约状态
    @RequestMapping("/updateService")
    public String updateService1(@RequestParam("metting_id") int metting_id) {
        Mettingroom update = new Mettingroom();
        update.setMettingroom_reserve("是");
        update.setMetting_id(metting_id);
        int flag = mettingRoomService.updateService(update);

        if (flag == 0) {
            return "error/404error";
        }
        return "redirect:showMettingRoom";
    }
}
    /*@RequestMapping("/insert")
    public String insert(@RequestParam("metting_id") Integer metting_id,
                          @RequestParam("emp_id")String emp_id,
                         @RequestParam("metting_room")String metting_room){
        mettingRoomService.insret(metting_id,emp_id,metting_room);
        return "redirect:/Role/showRole";
}*/
