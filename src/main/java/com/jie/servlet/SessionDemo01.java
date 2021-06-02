package com.jie.servlet;

import com.jie.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //解决乱码问题

        HttpSession session = req.getSession();
        //得到Session

        session.setAttribute("name",new Person("杰哥",34));
        //在Session中存东西

        String id = session.getId();
        //获取Session的id
        if (session.isNew()){
            resp.getWriter().write("session创建成功,id: "+ id);
        }else {
            resp.getWriter().write("session已经存在了,id: "+id);
        }
        //判断Session是不是新建的
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
