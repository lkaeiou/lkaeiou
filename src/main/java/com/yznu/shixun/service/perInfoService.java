package com.yznu.shixun.service;

import com.yznu.shixun.domain.Personal;

public interface perInfoService {
     Personal personInfomation(int personal_id);
     int updatePerInfomation(Personal person);
}
