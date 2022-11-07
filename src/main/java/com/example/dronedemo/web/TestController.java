package com.example.dronedemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author Zhou haiyang
 */
@Controller
public class TestController {

    @GetMapping(value = "/helloworld")
    protected String messageCallback(String data, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        out.print("hello world MMM: " + data);
        out.flush();
        return null;
    }

}
