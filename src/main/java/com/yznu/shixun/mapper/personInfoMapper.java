package com.yznu.shixun.mapper;

import com.yznu.shixun.domain.Personal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface personInfoMapper {
    Personal personInfo(int personal_id);
    int updatePerInfo(Personal person);
}
