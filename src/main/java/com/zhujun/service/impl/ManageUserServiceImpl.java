package com.zhujun.service.impl;

import com.zhujun.mapper.ManageUserMapper;
import com.zhujun.pojo.BackendUser;
import com.zhujun.service.ManageUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ManageUserServiceImpl implements ManageUserService {
    @Resource
    private ManageUserMapper manageUserMapper;

    //后台管理员登录
    public BackendUser ManageLogin(BackendUser backendUser) {
        System.out.println("manageUserMapper" + manageUserMapper == null);
        if (manageUserMapper.queryManaage(backendUser) != null) {
            return manageUserMapper.queryManaage(backendUser).get(0);
        }
        return null;
    }
}
