package com.tsl.emps.comon.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("explain","服务器开启了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
