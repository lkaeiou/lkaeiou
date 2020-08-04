package com.yznu.shixun.service.impl;

import com.yznu.shixun.domain.Personal;
import com.yznu.shixun.mapper.mailListMapper;
import com.yznu.shixun.service.mailListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class mailListServiceImpl implements mailListService {
    @Autowired
    private mailListMapper  mailListMapper;
    public List<Personal> mailSelect()
    {
        return mailListMapper.mailListSelect();
    }

    @Override
    public Personal mailsearch1(int id) {
        return mailListMapper.mailsearch(id);
    }
}
