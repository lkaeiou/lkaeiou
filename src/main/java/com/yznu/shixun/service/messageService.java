package com.yznu.shixun.service;

import com.yznu.shixun.domain.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public interface messageService {


     int sendmessage(String message_name, String message_content, int emp_id);//发送邮件
     List<Message> messageList(int emp_id);//收件箱信息
     int delmessage(int emp_id, int message_id);//删除信息
     int message_flag(int message_id, Integer emp_id);//标记信息状态
     int readmessage(int message_id, int emp_id);//标记为已读
     int newmessage();
     List<Message> messageList2(int emp_id);//已读信息
     List<Message> rubbushList(int emp_id);//已删除的信息
}
