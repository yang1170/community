package com.newcoder.community.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Repository
@Mapper
@Service
public interface MailClientService {
      String senMail(String to,String subject,String content);

    }
