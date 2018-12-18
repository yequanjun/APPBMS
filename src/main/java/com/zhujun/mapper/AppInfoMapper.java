package com.zhujun.mapper;

import com.zhujun.pojo.AppInfo;

import java.util.List;

public interface AppInfoMapper {
    //查询app
    List<AppInfo> queryApp(AppInfo appInfo);

    //查询app总数量
    int getAppCount(AppInfo appInfo);

    //查询 所有平台
    List<String> queryAllplatform();
}
