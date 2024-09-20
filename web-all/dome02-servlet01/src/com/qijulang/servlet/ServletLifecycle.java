package com.qijulang.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*
    @WebServlet(value = "/ServletLifecycle" ,loadOnStartup = -1)
    loadOnStartup默认值是  -1 含义是tomcat启动时不会实例化servlet，如果是其他正整数 例15 含义是tomcat启动时，
    会实例化servlet，并且按照loadOnStartup的值进行排序，值越大，越先实例化。如何序号冲突了tomcat会自动协调启动顺序
    */


@WebServlet("/ServletLifecycle" )
public class ServletLifecycle extends HttpServlet {
/*
    1、实例化       构造器     第一次请求时执行
    2、初始化       init      构造器执行完之后执行
    3、请求处理     service()        每次请求都会执行
    4、销毁        destroy()         关闭服务器时执行

    Servlet在Tomcat中是单例的，所以构造器只会执行一次
    Servlet的成员变量在多个线程之中是共享的
    不建议在Servlet方法中修改成员变量，在Servlet方法中修改成员变量，可能会导致线程安全问题



    dafault-servlet

 */

    public ServletLifecycle() {
        System.out.println("构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求处理");
    }

    public void destroy() {
        System.out.println("销毁");
    }
}
