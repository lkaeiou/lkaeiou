package com.yznu.shixun.service;


import com.yznu.shixun.domain.Metting;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;

@Service
public interface MettingService {
    List<Metting> showAllMetting();//会议显示
   // int findDepartmentByMetting_id(Integer metting_id);
    //增加会议
    int addMetting(Integer metting_id, Integer emp_id, String metting_room, Data metting_time, String metting_leader);
   //修改会议
    int updateMetting(Integer metting_id, Integer emp_id, String metting_room, Data metting_time, String metting_leader);

    int deleteMetting(Integer metting_id);//删除会议
}
