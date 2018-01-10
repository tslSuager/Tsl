package com.tsl.framework.mvc.servlet;

import com.tsl.framework.mvc.annotation.RequestPath;
import com.tsl.framework.mvc.entity.PathMapEntity;
import com.tsl.framework.mvc.exception.MVCException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class DispatcherServlet extends HttpServlet {
    String[] scanPackage = null;
    ClassLoader classLoader = null;
    List<String> scanClassNames = new ArrayList<>();
    Map<String, PathMapEntity> mapEntityMaps = new HashMap<>();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.得到请求并解析出请求路径
        String uri = req.getRequestURI();
        PathMapEntity mapEntity = null;
        //2.和扫描的所有路径进行匹配
        Set<String> keyPaths = mapEntityMaps.keySet();
        for (String keyPath : keyPaths) {
            if (uri.indexOf(keyPath) != -1) {
                mapEntity = mapEntityMaps.get(keyPath);
                break;
            }
        }
        if (mapEntity == null) {
            throw new MVCException("请求路径错误!!!");
        }
        try {
            Object obj = mapEntity.getClazz().newInstance();
            String invoke = (String) mapEntity.getMethod().invoke(obj, req, resp);
            if (invoke == null) {
                throw new MVCException("返回的请求路径错误!!!");
            }
            if (!invoke.startsWith("/")) {
                invoke = "/" + invoke;
            }
            if (invoke.indexOf(".") == -1) {
                invoke = invoke + ".do";
            }
            req.getRequestDispatcher(req.getContextPath() + invoke).forward(req, resp);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() throws ServletException {
        //1.读取配置的扫描路径
        String namespace = this.getServletConfig().getInitParameter("namespace");
        classLoader = Thread.currentThread().getContextClassLoader();
        if (namespace == null) {
            throw new MVCException("扫描路径读取失败或者未配置扫描路径参数：namespace！！！");
        } else {
            scanPackage = namespace.trim().split(",");
        }
        //2.找出所有扫描路径下的所有类
        if (scanPackage == null && scanPackage.length <= 0) {
            throw new MVCException("扫描路径未配置扫描具体路径！！！");
        } else {
            for (String eachPackge : scanPackage) {
                String packName = eachPackge.trim();
                String packPath = packName.replaceAll("\\.", "/");
                URL resource = classLoader.getResource(packPath);
                String filePath = resource.getPath();
                File allClassFile = new File(filePath);
                if (!allClassFile.isDirectory()) {
                    throw new MVCException("扫描具体路径配置错误！！！");
                } else {
                    for (File file : allClassFile.listFiles()) {
                        scanClassNames.add(packName + "." + file.getName().substring(0, file.getName().indexOf(".")));
                    }
                }
            }
        }
        //3.扫描路径下的所有类，找到所有配置的路径
        for (String className : scanClassNames) {
            try {
                Class clazz = Class.forName(className);
                String nameSpaceStr = "";
                RequestPath annotation = (RequestPath) clazz.getAnnotation(RequestPath.class);
                if (annotation != null) {
                    nameSpaceStr = annotation.value();
                }
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    RequestPath methodAnnotation = method.getAnnotation(RequestPath.class);
                    if (methodAnnotation != null) {
                        String path = nameSpaceStr + methodAnnotation.value();
                        mapEntityMaps.put(path, new PathMapEntity(path, clazz, method));
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
