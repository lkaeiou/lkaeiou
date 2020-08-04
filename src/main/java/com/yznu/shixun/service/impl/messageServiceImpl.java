package com.yznu.shixun.service.impl;

import com.yznu.shixun.domain.Message;
import com.yznu.shixun.mapper.messageMapper;
import com.yznu.shixun.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service

public class messageServiceImpl implements messageService {

    @Autowired
   messageMapper messagemapper;
    @Autowired
    Message message;

    public int sendmessage(String message_name,String message_content,int emp_id)  {//发送信息
        //int message_id=messagemapper.find_emp(personal_id);

      // String date = new Date(System.currentTimeMillis()).toString();


        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);

        // int message_id=messagemapper.findmess();
         //messagemapper.messageread(message_id);
         //System.out.println(message_id);
        return  messagemapper.sendmessage(message_name,message_content,emp_id);
    }

    public List<Message> messageList(int emp_id) {//信息列表

        return messagemapper.Recvmessage(emp_id);//显示正常状态的信息
    }
    public List<Message> messageList2(int emp_id) {//已读信息列表

        return messagemapper.Recvedmessage(emp_id);//
    }
    public int delmessage(int emp_id,int message_id){//删除信息

        return messagemapper.delete(emp_id,message_id);

    }
    public  int readmessage(int message_id,int emp_id){//已读信息

        return messagemapper.read(emp_id,message_id);
    }
    public int message_flag(int message_id, Integer emp_id){//标记信息

        return messagemapper.messageflag(message_id,emp_id);
    }
    public int newmessage(){
        return messagemapper.findmess_read();
    }
    public List<Message> rubbushList(int emp_id) {//已删除信息列表

        return messagemapper.rubmessage(emp_id);
    }
}
