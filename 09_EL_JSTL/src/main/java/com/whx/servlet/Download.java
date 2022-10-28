package com.whx.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.function.DoubleUnaryOperator;

/**
 * @author WhitehatXiao
 * @date 2022/9/23
 * @descriptions  下载文件demo
 */
public class Download extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、获取需要下载的文件名
        String downName = "我的照片.jpg";
        // 2、读取需要下载的文件内容（ servletContext 对象可以读取
        ServletContext servletContext = getServletContext();
        /**
         *  / 斜杠会被服务器解析成 工程路劲地址  http://ip:port/工程路径名/ 映射到代码的web目录
         */

        // 4、在回传前，通过响应头告诉客户端放回数据类型
        String mimeType = servletContext.getMimeType("/"+downName);
        resp.setContentType(mimeType);
        /**
         * content-Disposition 响应头,表示收到的数据如何处理
         * attachment 表示附件,表示下载使用
         * filename = 表示下载指定文件
         */
        resp.setHeader("content-Disposition", "attachment; filename="+downName);
        // 5、还要告诉客户端收到的数据是用于下载使用（ 还是使用响应头 ： 如果不告诉客户需要下载，那么就会在浏览器直接显示文件

        //
        // Set<String> resourcePaths = servletContext.getResourcePaths("/resource/" + downName);
        // System.out.println("resourcePaths"  + resourcePaths);
        // String realPath = servletContext.getRealPath("/resource/" + downName);
        // System.out.println("realPath" + realPath);

        InputStream inputStream = servletContext.getResourceAsStream("/"+downName);
        ServletOutputStream outputStream = resp.getOutputStream();
        // 3、把下载的文件内容回传给客户端
        IOUtils.copy(inputStream, outputStream);

    }
}
