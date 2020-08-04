package com.yznu.shixun.service;

import com.yznu.shixun.domain.Personal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface mailListService {
      List<Personal> mailSelect();
      Personal mailsearch1(int id);
}
