package com.example.dronedemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.net.InetAddress;

/**
 * @author Zhou haiyang
 */
@Controller
public class TestController {

    @GetMapping(value = "/helloworld")
    protected String messageCallback(String data, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        InetAddress host = InetAddress.getLocalHost();// 获得本机的InetAddress对象
        String hostAddress = host.getHostAddress();// 获得本机的IP地址
        out.print("hello world[" + hostAddress + "] YYY: " + data);
        out.flush();
        return null;
    }

}
