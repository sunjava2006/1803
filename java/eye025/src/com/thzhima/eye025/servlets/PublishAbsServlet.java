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
				for(int i=0; i<items.size(); i++) {
					FileItem item = items.get(i);
					if(item.isFormField()) { // 是普通form 中的输入元素
						 String name = item.getFieldName();
						 String value = item.getString();
						 System.out.println(name +":"+value);
					}else { // 是文件
						String fileName = item.getFieldName();
						String name = item.getName();
						System.out.println(name);
						if(!"".equals(name)) {
							item.write(new File(picDir+"/", name));
						}
						
					}
				}
			} catch ( Exception e) {
				e.printStackTrace();
			}
		}
			
		
	}

}
