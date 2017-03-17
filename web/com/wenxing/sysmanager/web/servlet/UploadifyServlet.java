package com.wenxing.sysmanager.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.wenxing.commons.helper.DateHelper;
import com.wenxing.commons.helper.StringHelper;

public class UploadifyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//上传文件的保存路径
	protected String configPath = "attached/";

	protected String dirTemp = "attached/temp/";
	
	protected String dirName = "file";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doPost(request, response);
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//文件保存目录路径
		String realPath = this.getServletContext().getRealPath("/");
		String savePath = realPath + configPath;
		
		// 临时文件目录 
		String tempPath = realPath + dirTemp;
		
		String ymd = DateHelper.dateToStrYMD(new Date());
		
		String folderName = "";
		
		
		
		tempPath += "/" + ymd + "/";
		//创建临时文件夹
		File dirTempFile = new File(tempPath);
		if (!dirTempFile.exists()) {
			dirTempFile.mkdirs();
		}
		
		DiskFileItemFactory  factory = new DiskFileItemFactory();
		factory.setSizeThreshold(5 * 1024 * 1024); //设定使用内存超过5M时，将产生临时文件并存储于临时目录中。   
		factory.setRepository(new File(tempPath)); //设定存储临时文件的目录。   

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		
        OutputStream os = null;
        InputStream is = null;
		 
		try {
			List items = upload.parseRequest(request);
			Iterator itr = items.iterator();
			
			
			System.out.println(items.size()+"~~~~~~~~~");
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				String fileName = item.getName();
				long fileSize = item.getSize();
				if (!item.isFormField()) {
					String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
					
					SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
					String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
					
					if(StringHelper.isNotEmpty(folderName)) {
						savePath = StringHelper.append(savePath,"/",folderName,"/",ymd,"/");
					}
					//创建文件夹
					File dirFile = new File(savePath);
					if (!dirFile.exists()) {
						dirFile.mkdirs();
					}
					
					try{
						File uploadedFile = new File(savePath, newFileName);
						
						/*
						 * 第一种方法
						 * 
						 * 好处： 一目了然..简单啊...
						 * 弊端： 这种方法会导致上传的文件大小比原来的文件要大
						 * 
						 * 推荐使用第二种
						 */
						//item.write(uploadedFile);
						//--------------------------------------------------------------------
						//第二种方法
						os = new FileOutputStream(uploadedFile);
						is = item.getInputStream();
	                    byte buf[] = new byte[1024];//可以修改 1024 以提高读取速度
	                    int length = 0;  
	                    while( (length = is.read(buf)) > 0 ){  
	                        os.write(buf, 0, length);  
	                    }  
	                    
	                    String filePath = savePath.substring(realPath.length());
	                    System.out.println("上传成功！路径："+filePath+"/"+newFileName);
	                    out.print(filePath+"/"+newFileName);
					}catch(Exception e){
						e.printStackTrace();
					}
				}else {
					String filedName = item.getFieldName();
					if (filedName.equals("folderName")) {
						folderName = item.getString();
					}
					System.out.println("==============="); 
				}			
			} 
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//关闭流  
			if (os != null){
				os.flush();
				os.close();
			}
			if(is != null) {
				is.close();
			}
            if(out != null) {
            	out.flush();
    			out.close();
            }
			
		}
		
	}

}
