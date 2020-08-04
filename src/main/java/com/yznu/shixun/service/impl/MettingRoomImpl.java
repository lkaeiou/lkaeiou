package com.yznu.shixun.service.impl;

import com.yznu.shixun.domain.Metting;
import com.yznu.shixun.domain.Mettingroom;
import com.yznu.shixun.mapper.MettingMapper;
import com.yznu.shixun.mapper.MettingRoomMapper;
import com.yznu.shixun.service.MettingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MettingRoomImpl implements MettingRoomService {
    @Autowired
    Mettingroom mettingroom;
    @Autowired
    MettingRoomMapper mettingRoomMapper;
    @Override
    public List<Mettingroom> showAllMettingRoom() {
        List<Mettingroom> show=mettingRoomMapper.showAllMettingRoom();
        return show;
    }

    public int updateService(Mettingroom mettingroom) {
        int update=mettingRoomMapper.updateService(mettingroom);
        return update;

    }

    @Override
    public int insret(Mettingroom mettingroom) {
        int insert=mettingRoomMapper.insert(mettingroom);
        return insert;

    }
}
