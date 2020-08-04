package com.yznu.shixun.service.impl;

import com.yznu.shixun.domain.Department;
import com.yznu.shixun.domain.Metting;
import com.yznu.shixun.mapper.MettingMapper;
import com.yznu.shixun.service.MettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class MettingImpl implements MettingService {
    @Autowired
    Metting metting;
    @Autowired
    MettingMapper mettingMapper;

    /**
     * 会议显示
     * @return
     */
    @Override
    public List<Metting> showAllMetting() {
        List<Metting> show=mettingMapper.showAllMetting();
        return show;
    }

    /**
     * 添加会议
     * @param metting_id
     * @param emp_id
     * @param metting_room
     * @param metting_time
     * @param metting_leader
     * @return
     */
    @Override
    public int addMetting(Integer metting_id, Integer emp_id, String metting_room, Data metting_time, String metting_leader) {
        metting.setMetting_id(metting_id);
        metting.setEmp_id(emp_id);
        metting.setMetting_room(metting_room);
        metting.setMetting_time((Date) metting_time);
        metting.setMetting_leader(metting_leader);
        int add=mettingMapper.addMetting(metting);
        return add;
    }

    /**
     * 修改会议
     * @param metting_id
     * @param emp_id
     * @param metting_room
     * @param metting_time
     * @param metting_leader
     * @return
     */
    @Override
    public int updateMetting(Integer metting_id, Integer emp_id, String metting_room, Data metting_time, String metting_leader) {
        metting.setMetting_id(metting_id);
        metting.setEmp_id(emp_id);
        metting.setMetting_room(metting_room);
        metting.setMetting_time((Date) metting_time);
        metting.setMetting_leader(metting_leader);
        int update=mettingMapper.updateMetting(metting);
        return update;
    }

    /**
     * 删除会议
     * @param metting_id
     * @return
     */
    @Override
    public int deleteMetting(Integer metting_id) {
        mettingMapper.deleteMetting(metting_id);
        return 0;
    }
}
