package com.yznu.shixun.mapper;

import com.yznu.shixun.domain.Metting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MettingMapper {
    List<Metting> showAllMetting();   //显示会议信息

   // Metting findDepartmentByMetting_id(int metting_id); //查询单个会议信息

    int addMetting(Metting metting);    //新增会议信息

    int updateMetting(Metting metting); //修改会议信息

    int deleteMetting(int metting_id);     //删除会议信息

}
