package com.yznu.shixun.service;


import com.yznu.shixun.domain.Mettingroom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MettingRoomService {
    List<Mettingroom> showAllMettingRoom();//会议显示
    int updateService(Mettingroom mettingroom);            //修改预约状态
    int insret(Mettingroom mettingroom);
    //void updateService(Mettingroom update);
  /* // int findDepartmentByMetting_id(Integer metting_id);
    //增加会议
    int addMetting(Integer metting_id, Integer emp_id, String metting_room, Data metting_time, String metting_leader);
   //修改会议
    int updateMetting(Integer metting_id, Integer emp_id, String metting_room, Data metting_time, String metting_leader);

    int deleteMetting(Integer metting_id);//删除会议*/
}
