package com.zhujun.controller;

import com.zhujun.pojo.AppInfo;
import com.zhujun.service.AppInfoService;
import com.zhujun.tools.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/doAppInfo")
public class AppController {
    @Resource
    private AppInfoService appInfoService;

    @RequestMapping("/queryAllApp")
    public String queryAllApp(AppInfo appInfo, ModelMap modelMap, @RequestParam(value = "pageNumberVar", required = false) String pageNumberVar) {
        List<AppInfo> list = appInfoService.queryAllAppInfo(appInfo, pageNumberVar);
        modelMap.addAttribute("appInfoList", list);

        return "developer/appinfolist";
    }

    //
    @RequestMapping("/queryAllStatus")
    public @ResponseBody
    Object queryAllStatus(@RequestParam("platform") String platform) {
        AppInfo exAppInfo = new AppInfo();
        /* exAppInfo.setFlatformName(platform);*/
        /*List<AppInfo> list=appInfoService.queryAllMsg(exAppInfo);*/
        return "";
    }
}
