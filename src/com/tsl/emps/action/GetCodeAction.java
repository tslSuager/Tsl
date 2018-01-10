package com.tsl.emps.action;

import com.tsl.framework.mvc.annotation.RequestPath;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@RequestPath("/code")
public class GetCodeAction {
    @RequestPath("/get.do")
    public String getCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应类型,浏览器知道是什么类型
        int width = 100;
        int height = 30;
        response.setContentType("image/jpeg");
        //禁止浏览器缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        BufferedImage codeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = codeImage.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);//背景颜色
        char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        char[] codes = new char[4];
        StringBuilder strb = new StringBuilder();
        for (int i = 0; i < codes.length; i++) {
            codes[i] = chars[(int) (Math.random() * chars.length)];
            strb.append(codes[i]);
        }
        request.getSession().setAttribute("ver_code", strb.toString());
        g.setColor(Color.WHITE);
        g.setFont(new Font("楷体", Font.ITALIC, 20));
        g.drawString("" + codes[0], 5, 20);
        g.drawString("" + codes[1], 25, 20);
        g.drawString("" + codes[2], 45, 20);
        g.drawString("" + codes[3], 65, 20);
        g.dispose();
        OutputStream out = response.getOutputStream();
//        ???
        ImageIO.write(codeImage, "JPEG", out);
        out.flush();
        out.close();

        return null;
    }


}
