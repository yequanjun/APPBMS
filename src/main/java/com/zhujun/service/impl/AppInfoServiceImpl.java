package com.zhujun.service.impl;

import com.zhujun.mapper.AppInfoMapper;
import com.zhujun.pojo.AppInfo;
import com.zhujun.service.AppInfoService;
import com.zhujun.tools.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppInfoServiceImpl implements AppInfoService {
    @Resource
    private AppInfoMapper appInfoMapper;

    @Override
    public List<AppInfo> queryAllAppInfo(AppInfo appInfo, String pageNumberVar) {
        int pageNumber = 1;
        if (pageNumberVar != null) {
            pageNumber = Integer.parseInt(pageNumberVar);
        }
        int paSize = 5;
        appInfo.setStart(Page.getStart(1, 5));
        appInfo.setSize(paSize);
        return appInfoMapper.queryApp(appInfo);
    }

    @Override
    public int getAppCount(AppInfo appInfo) {
        return 0;
    }

    @Override
    public List<String> queryAllPlatform() {
        return null;
    }
}
