package com.zhujun.service;

import com.zhujun.pojo.Admin;
import com.zhujun.pojo.BackendUser;


public interface ManageUserService {
    //后台管理员登录
    BackendUser ManageLogin(BackendUser backendUser);
}
