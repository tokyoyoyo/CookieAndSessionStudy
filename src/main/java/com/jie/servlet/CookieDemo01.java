package com.jie.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
       // resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        //服务器从客户端获取cookie
        Cookie[] cookies = req.getCookies();
        //用数组接受，Cookie可能存在多个
        if (cookies != null){
            writer.write("你上一次访问时间为：");
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                System.out.println("这个cookie的名字是：" + name);
                if (name.equals("LastLoginTime")){
                    long lon = Long.parseLong(cookie.getValue());
                    Date date = new Date(lon);
                    writer.write(date.toString());
                }
            }
        }else {
            writer.write("这是您第一次访问本站");
        }
        Cookie cookie = new Cookie("LastLoginTime",System.currentTimeMillis()+"");
        resp.addCookie(cookie);
        cookie = new Cookie("name", URLEncoder.encode("杰哥","utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
