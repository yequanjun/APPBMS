package com.zhujun.mapper;

import com.zhujun.pojo.DevUser;

import java.util.List;

public interface DeveUserMapper {
    //开发者查询
    List<DevUser> queryDeve(DevUser devUser);
}
