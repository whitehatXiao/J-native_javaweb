package com.whx.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author WhitehatXiao
 * @date 2022/9/23
 * @descriptions  上传文件 demo
 */
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("访问 UploadServlet ");
        // ServletInputStream inputStream = req.getInputStream();
        // byte[] buffer = new byte[1024000];
        // int read = inputStream.read(buffer);
        // System.out.println(new String(buffer,0,read));

        // 1. 先判断上传的数据是否是多段数据（ 只有是多段的数据，才是文件上传的
        if(ServletFileUpload.isMultipartContent(req)){
        //    创建 FileItemFactory 工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用户解析上传数据的工具类 ServletFileUpload 类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            try {
                // 解析上传的数据，得到每一个表单项 FileItem
                List<FileItem> list = servletFileUpload.parseRequest(req);

                // 循环判断每一个表单项, 到底是普通表单项 , 还是上传的文件
                //  可以用 http协议对uploadFile的描述,它是用boundy分隔符分开的 , 其中包含普通表象和上传的文件
                for (FileItem fileItem : list) {
                    if (fileItem.isFormField()){
                    //    普通表单项
                        System.out.println("表单项的name属性:" + fileItem.getFieldName());
                        System.out.println("表单项的value属性:" + fileItem.getString());
                    }else{
                        // 上传的文件
                        System.out.println("表单项的 name 属性值：" + fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        try {
                            fileItem.write(new File("e:\\" + fileItem.getName()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }

    }
}
