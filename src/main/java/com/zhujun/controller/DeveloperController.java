package com.zhujun.controller;

import com.zhujun.pojo.DevUser;
import com.zhujun.service.DeveloperService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/doDeveloper")
public class DeveloperController {
    @Resource
    private DeveloperService developerService;

    //去开发者登录
    @RequestMapping("/toDeveloperLogin")
    public String toDeveloperLogin() {
        return "devlogin";
    }

    //开发者登录
    @RequestMapping("/developerLogin")
    public String developerLogin(DevUser devUser, HttpSession session, HttpServletResponse response) throws IOException, InterruptedException {
        if (session.getAttribute("devUserSession") == null) {
            DevUser devUser1 = developerService.devLogin(devUser);
            if (devUser1 != null) {
                session.setAttribute("devUserSession", devUser1);
                return "developer/main";
            } else {
                return "redirect:/index.jsp";
            }
        }
        return "developer/main";
    }

    //开发者注销
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute("devUserSession");
        return "redirect:/index.jsp";

    }
}
