package com.zhujun.mapper;

import com.zhujun.pojo.BackendUser;

import java.util.List;

public interface ManageUserMapper {
    List<BackendUser> queryManaage(BackendUser backendUser);
}
