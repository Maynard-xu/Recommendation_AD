package com.xujin.ad_sender.service;

import com.xujin.ad_sender.dao.RegisterDao;
import com.xujin.ad_sender.entity.RegisterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * \* Created with IntelliJ IDEA.
 * \* Description:
 * \* User: xujin
 * \* Date: 2018/3/16
 * \* Time: 21:50
 * \
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    RegisterDao registerDao;


    @Override
    public void register(RegisterEntity registerEntity) {
        registerDao.register(registerEntity);
    }
}