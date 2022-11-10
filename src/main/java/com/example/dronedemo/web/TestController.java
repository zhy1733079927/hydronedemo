package com.example.dronedemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author Zhou haiyang
 */
@Controller
public class TestController {

    @GetMapping(value = "/helloworld")
    protected String messageCallback(String data, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        String hostAddress = getInet4Address();// 获得本机的IP地址
        out.print("hello world[" + hostAddress + "] 555: " + data);
        out.flush();
        return null;
    }

    public static String getInet4Address() {
        Enumeration nis;
        String ip = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
            for (; nis.hasMoreElements(); ) {
                NetworkInterface ni = (NetworkInterface) nis.nextElement();
                Enumeration ias = ni.getInetAddresses();
                for (; ias.hasMoreElements(); ) {
                    InetAddress ia = (InetAddress) ias.nextElement();
                    if (ia instanceof Inet4Address && !ia.getHostAddress().equals("127.0.0.1")) {
                        ip = ia.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return ip;

    }

}
