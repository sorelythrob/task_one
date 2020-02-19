package com.task.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.task.bean.User;
import com.task.service.UserService;
import com.task.service.impl.UserServiceImpl;
import com.task.util.WEButils;
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	public UserServlet() {
		super();
	}

	protected void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = WEButils.params2bean(request, new User());
		
		User uu = userService.login(user);
		
		if (uu == null) {
			request.setAttribute("msg", "用户名密码错误");
			
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
			
		} else {
			
			
			HttpSession session = request.getSession();
			String id = session.getId();
			Cookie cookie = new Cookie("JSESSIONID",id);
			cookie.setMaxAge(20);
			response.addCookie(cookie);
			session.setAttribute("user",uu);
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		}

	}

	protected void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		 String username = request.getParameter("username");
//		 String password = request.getParameter("password");
//		 String email = request.getParameter("email");
//		boolean regist = userService.regist(new User(null, username, password, email));


		User user = WEButils.params2bean(request, new User());
		boolean regist = userService.regist(user);


		if (regist) {
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
		} else {
			request.setAttribute("msg", "用户名已存在");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}
	
	

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
		
		
	}
	
	

	protected void restrict(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Object attribute = session.getAttribute("user");
		if(attribute==null) {
			response.sendRedirect(request.getContextPath()+"/pages/user/login.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/pages/user/check.jsp");
		}
		
	}
	

	protected void upHead(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		User user = (User)request.getSession().getAttribute("user");
		System.out.println(user);
		try {
			List<FileItem> parseRequest = upload.parseRequest(request);
			for (FileItem fileItem : parseRequest) {
				//System.out.println(fileItem.getFieldName());   head
				String name = fileItem.getName();    //1.jpg  
				int lastIndexOf = name.lastIndexOf("\\");
				if(lastIndexOf!=-1) {
					name=name.substring(lastIndexOf+1);
				}
				ServletContext servletContext = getServletContext();
				String realPath = servletContext.getRealPath("/imgs");
				InputStream is = fileItem.getInputStream();
				String prefix=UUID.randomUUID().toString().replace("-", "")+"_"+name;
				name=realPath+"\\"+prefix;
				System.out.println(name);
				user.setHeadPath("imgs/"+prefix);
				request.getSession().setAttribute("user",user);
				User attribute = (User)request.getSession().getAttribute("user");
				System.out.println(attribute);
				FileOutputStream os = new FileOutputStream(name);
				IOUtils.copy(is, os);
				os.close();
					
			}
			
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
	}
	

}