package com.tsl.emps.action;

import com.tsl.emps.domain.User;
import com.tsl.emps.serviece.UserService;
import com.tsl.emps.serviece.UserServiceImpl;
import com.tsl.framework.mvc.annotation.RequestPath;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RequestPath("/user")
public class UserAction {
    UserService userService;

    public UserAction() {
        userService = new UserServiceImpl();
    }

    @RequestPath("/login")
    public String login(HttpServletRequest res, HttpServletResponse resp) {
        String pathReturn = "";
        if (res.getSession().getAttribute("loginFail") != null) {
            if (!res.getSession().getAttribute("ver_code").equals(res.getParameter("code"))) {
                res.setAttribute("errMsg", "验证码错误！");
                return "WEB-INF/emp/emp_login.jsp";
            }
        }
        String name = res.getParameter("name");
        User userByName = userService.findUserByName(name);
        if (userByName != null) {
            String password = res.getParameter("password");
            if (userByName.getPassword().equals(password)) {
                res.getSession().setAttribute("loginUser",userByName);
                res.getSession().setAttribute("imageName",userByName.getImage().substring(userByName.getImage().lastIndexOf("\\")+1));
                pathReturn= "emp/list.do?pageCurrent=1&pageSize=6";
            } else {
                res.getSession().setAttribute("loginFail",true);
                res.setAttribute("errMsg", "密码错误！");
                pathReturn= "WEB-INF/emp/emp_login.jsp";
            }
        } else {
            res.getSession().setAttribute("loginFail",true);
            res.setAttribute("errMsg", "用户不存在！");
            pathReturn= "WEB-INF/emp/emp_login.jsp";
        }
        return pathReturn;
    }
    @RequestPath("/exit")
    public String exit(HttpServletRequest res, HttpServletResponse resp) {
        res.getSession().setAttribute("loginUser", null);
        res.getSession().setAttribute("imageName", null);
        res.getSession().invalidate();
        return "index.jsp";
    }
    @RequestPath("/toregister")
    public String toRegister(HttpServletRequest res, HttpServletResponse resp) {
        return "WEB-INF/emp/emp_register.jsp";
    }
    @RequestPath("/register")
    public String register(HttpServletRequest res, HttpServletResponse resp) {
        String[] imageTypes = new String[]{"image/jpeg", "image/png", "image/bmp"};
        boolean isMultipart = ServletFileUpload.isMultipartContent(res);//验证提交的格式
        User user =null;
        if (isMultipart) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                user = new User();
                List<FileItem> fileItems = upload.parseRequest(res);
                for (FileItem item : fileItems) {
                    if (item.isFormField()) {
                        String name = item.getFieldName();//
                        switch (name){
                            case "name":
                                user.setName(item.getString("UTF-8"));
                                break;
                            case "password":
                                user.setPassword(item.getString("UTF-8"));
                        }
                    } else {
                        String fieldName = item.getFieldName();
                        String fileName = item.getName();
                        String contentType = item.getContentType();
                        long sizeInBytes = item.getSize();
                        boolean contains = Arrays.asList(imageTypes).contains(contentType);
                        if (!(contains&&sizeInBytes<100000)) {
                            res.setAttribute("errMsg","上传失败");
                            return "WEB-INF/emp/emp_regist.jsp";
                        }
                        String path = "";
                        path=res.getSession().getServletContext().getRealPath("upload");
                        String nameFile = new SimpleDateFormat("yyyyMMddhhmm").format(new Date()) + (int) (Math.random() * 10000) + fileName.substring(fileName.lastIndexOf("."));
                        path = path + "\\" + nameFile;
                        user.setImage(path);
                        File f = new File(path);
                        if(!f.exists()){
                            f.createNewFile();
                        }
                        item.write(f);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (user != null) {
            userService.addUSer(user);
            res.setAttribute("errMsg","注册成功");
        }
        return "WEB-INF/emp/emp_login.jsp";
    }


}
