package com.yznu.shixun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class fakeController {
    @RequestMapping("/daibanshi")
    public String  daiban()
    {
        return "emp/blank";
    }
    @RequestMapping("/richenganpai")
    public String  richeng()
    {
        return "emp/calendar";
    }
    @RequestMapping("/wenjianjia")
    public String wenjian()
    {
        return "emp/media-manager";
    }
}
