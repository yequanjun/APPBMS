package com.zhujun.service;

import com.zhujun.pojo.AppInfo;

import java.util.List;

public interface AppInfoService {
    //查询所有app
    List<AppInfo> queryAllAppInfo(AppInfo appInfo, String pageNumberVar);

    //查询所有app条数
    int getAppCount(AppInfo appInfo);

    //查询所有平台
    List<String> queryAllPlatform();

}
