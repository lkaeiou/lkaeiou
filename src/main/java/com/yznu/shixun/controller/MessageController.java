package com.yznu.shixun.controller;

import com.sun.istack.internal.NotNull;
import com.yznu.shixun.domain.Emp;
import com.yznu.shixun.domain.Message;
import com.yznu.shixun.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

@Controller
@RequestMapping("/message")
@Scope("prototype")
@SessionAttributes("emp")
public class MessageController {

@Autowired
Message message;

    /**
     *
     */
    @Autowired
    messageService messageservice;
    @RequestMapping("/message")
    public String message() {//跳转到messages.html页面

        return "message/messages";
    }
    @RequestMapping("/tosendmessage")
    public String sendmessage() {//跳转到发送信息页面


        return "message/sendmail";
    }
    @RequestMapping(value = "/send")
    @Scope("prototype")

    public String send(Message message, HttpSession httpSession, @ModelAttribute("emp") Emp emp, ModelMap model) throws ParseException {//发送信息


        Integer emp_id = emp.getEmp_id();
        Emp es=(Emp)httpSession.getAttribute("emp");
        Integer emp_id2 = es.getEmp_id();
String message_name=message.getMessage_name();
String message_content=message.getMessage_content();
System.out.println(emp_id2);
        messageservice.sendmessage(message_name,message_content,emp_id);

        return "message/messages";
    }
    @RequestMapping("/view")
    @Scope("prototype")
    public String view(){
        return "message/view_message";
    }//跳转信息详情界面
    @RequestMapping("/messages_list")
    @Scope("prototype")
    public String list(@NotNull Model model,HttpSession httpSession){//读取收件箱信息
        //List<message> massages=messageservice.messageList();
        Emp emp=(Emp)httpSession.getAttribute("emp");
        Integer emp_id = emp.getEmp_id();
        System.out.println("list"+emp_id);
        Object messages=messageservice.messageList(emp_id);//获取信息表数据
        String a=messages.toString();
        model.addAttribute("message",messages);//前端使用对象
        System.out.println(a);
        return "message/messages";
    }
    @RequestMapping("/readed")
    @Scope("prototype")
    public String readed_list(@NotNull Model model,HttpSession httpSession){//已读信息获取
        //List<message> massages=messageservice.messageList();
        Emp emp=(Emp)httpSession.getAttribute("emp");
        Integer emp_id = emp.getEmp_id();
        System.out.println("list"+emp_id);
        Object messages=messageservice.messageList2(emp_id);
        String a=messages.toString();
        model.addAttribute("message",messages);//前端使用对象
        System.out.println(a);
        return "message/messages";
    }
    @RequestMapping(value = "/isread/{message_id}", method = RequestMethod.GET)
    @Scope("prototype")
    public String read(@PathVariable("message_id") int message_id,@ModelAttribute("emp") Emp emp){//将信息标为已读
        //获取
        Integer emp_id = emp.getEmp_id();
        System.out.println("read"+emp_id);
        messageservice.message_flag(emp_id,message_id);//将信息加入已读信息表
        System.out.println("read"+emp_id);
        System.out.println("read"+message_id);
        // messageservice.newmessage();//新生成一条emp_id=0,其他信息对应message_id信息的一条记录
        //int id=messageservice.newmessage();
        System.out.println("read"+message_id);
        int i=messageservice.readmessage(emp_id,message_id);
        System.out.println(i);
        messageservice.messageList2(emp_id);
        return "message/messages";
    }
    @RequestMapping(value = "/del/{message_id}", method = RequestMethod.GET)
    public String delete(@PathVariable("message_id") int message_id,HttpSession httpSession){
        //获取id,删除信息
        Emp emp=(Emp)httpSession.getAttribute("emp");
        Integer emp_id = emp.getEmp_id();
        messageservice.message_flag(emp_id,message_id);//将信息加入已读信息表
        messageservice.delmessage(emp_id,message_id);//将message_read表中对应massage_id的delete_flag转换为1
        return "message/messages";
    }
    @RequestMapping("/rub")
    @Scope("prototype")
    public String rubbushlist(@NotNull Model model,HttpSession httpSession){//已删除的信息
        //List<message> massages=messageservice.messageList();
        Emp emp=(Emp)httpSession.getAttribute("emp");
        Integer emp_id = emp.getEmp_id();
        System.out.println("list"+emp_id);
        Object messages=messageservice.rubbushList(emp_id);
        String a=messages.toString();
        model.addAttribute("message",messages);
        System.out.println(a);
        return "message/messages";
    }
}
