package com.yznu.shixun.service.impl;

import com.yznu.shixun.domain.Personal;
import com.yznu.shixun.mapper.personInfoMapper;
import com.yznu.shixun.service.perInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class personInfoServiceImpl implements perInfoService {
    @Autowired
    private personInfoMapper personInfoMapper;
    @Override
    public Personal personInfomation(int personal_id) {
        return personInfoMapper.personInfo(personal_id);
    }

    @Override
    public int updatePerInfomation(Personal person) {
          return personInfoMapper.updatePerInfo(person);
    }
}
