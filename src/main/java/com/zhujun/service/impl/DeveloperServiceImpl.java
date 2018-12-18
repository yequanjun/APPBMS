package com.zhujun.service.impl;

import com.zhujun.mapper.DeveUserMapper;
import com.zhujun.pojo.DevUser;
import com.zhujun.service.DeveloperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Resource
    private DeveUserMapper deveUserMapper;

    public DevUser devLogin(DevUser devUser) {
        if (deveUserMapper.queryDeve(devUser) != null && deveUserMapper.queryDeve(devUser).size() > 0) {
            return deveUserMapper.queryDeve(devUser).get(0);
        }
        return null;
    }
}
