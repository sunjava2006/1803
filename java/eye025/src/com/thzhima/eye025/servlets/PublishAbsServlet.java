package com.thzhima.eye025.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.thzhima.eye025.service.AbstractService;




@WebServlet("/publishAbs")
public class PublishAbsServlet extends HttpServlet {

	DiskFileItemFactory factory;
	String picDir;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		//获取应用全局对象ServletContext
		ServletContext app = config.getServletContext();
		
		picDir = app.getRealPath("/pictures");// 获取/pictures所在的物理路径。
		System.out.println(picDir);
		File repository = new File(picDir);
		
		// 设置磁盘缓冲阀值和，缓冲目录。
		factory = new DiskFileItemFactory(1024, repository);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws 
	ServletException, IOException {
		if(ServletFileUpload.isMultipartContent(request)) {
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				List<FileItem> items = upload.parseRequest(request);
				String content = null;
				boolean publishStatus = false;
				String p1 = null ,p2 = null, p3 = null;
				
				for(int i=0; i<items.size(); i++) {
					FileItem item = items.get(i);
					if(item.isFormField()) { // 是普通form 中的输入元素
						 String name = item.getFieldName();
						 String value = item.getString();
						 value = new String(value.getBytes("iso-8859-1"),"utf-8"); // 转码。
						 System.out.println(name +":"+value);
						 if("content".equals(name)) {
			
							 content = value;
						 }
						 else if("publishStatus".equals(name)) {
							 publishStatus = "on".equals(value) ? true : false;
						 }
					}else { // 是文件
						String getFieldName = item.getFieldName();
						String name = item.getName(); // 取上传的文件名
						
						// 取随机数为新文件名，与文件名后缀。产生一个新的文件名。
						String prefix = String.valueOf((long)(Math.random()*1000000000000L));
						String surfix = name.substring(name.lastIndexOf("."));
						name = prefix + surfix;
						
						System.out.println(name);
						if(!"".equals(name)) {
							item.write(new File(picDir+"/", name)); // 存文件。
							if("picture1".equals(getFieldName)) {
								p1 = "/pictures/"+name;
							}
							else if("picture2".equals(getFieldName)) {
								p2 = "/pictures/"+name;
							}
							else if("picture3".equals(getFieldName)) {
								p3 = "/pictures/"+name;
							}
						}
						
					}
				}
				
				AbstractService.publish(content, publishStatus, p1, p2, p3);
				
			} catch ( Exception e) {
				e.printStackTrace();
			}
		}
			
		
	}

}
