package com.qijulang.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;


/*
  servlet:开发流程：
  1、创建javeWeb项目，同时tocmat添加为当前项目的依赖
  2、重写service方法;
  3、在service方法中,定义业务处理代码
  4、在web.xml中，配置Servlet对应的请求映射路径

1、Servlet-api.jar   导入问题
    Servlet-api.jar 编写的时候需要，运行时，运行时由tomcat提供
2、Content-Type响应头的问题
        MIME类型响应头
        MIME类型响应头用于告诉客户端响应的数据是什么类型，客户端以此类型决定用什么方式解析响应体

 */
@WebServlet("/user")   //web.xml中配置的映射路径,不能同时存在。路径为请求页面得action="user"
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从requst中获取请求参数(username参数)
        String username=req.getParameter("username");
        //2、处理业务的代码
        String info="<h1>yes<h1>";


        if ("gtguigu".equals(username)){
            info="no";
        }
        //3、将要响应的数据放入response
        //3.1设置响应头
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter write = resp.getWriter();//该方法返回的是一个响应体中打印字体的打印流
        write.println(info);
    }
}
