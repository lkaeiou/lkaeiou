package com.yznu.shixun.mapper;

import com.yznu.shixun.domain.Personal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface mailListMapper {
    List<Personal>  mailListSelect();
    Personal mailsearch(int id);
}
