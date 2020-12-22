package com.tronghoang.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tronghoang.dao.UserDao;
import com.tronghoang.dao.impl.UserDaoImpl;
import com.tronghoang.library.MD5Encoder;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/admin/user/add")
public class AddUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/addUser.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = new User();
		UserDao userDao = new UserDaoImpl();
		HttpSession sesson = req.getSession();

		// tao doi tuong luu file
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//// set dia chi luu file
		factory.setRepository(new File("E:\\Java\\HoaLanVN\\WebContent\\upload\\user"));

		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		// doc request tu client gui len trong form upload
		try {
			List<FileItem> itemList = servletFileUpload.parseRequest(req);
			Iterator<FileItem> iteml = itemList.iterator();

			while (iteml.hasNext()) {
				FileItem item = iteml.next();
				if (item.getFieldName().equals("fullname")) {
					String fullname = item.getString("UTF-8");
					System.out.println(fullname);
					user.setFullname(fullname);
				}
				if (item.getFieldName().equals("username")) {
					String username = item.getString();
					User userList = userDao.searchUserName(username);
					if (userList == null) {
						user.setUsername(username);
					} else {

					}

				}
				if (item.getFieldName().equals("password")) {
					String password = item.getString();
					req.setAttribute("password", password);
				}
				if (item.getFieldName().equals("confirmpassword")) {
					String confirmpassword = item.getString();
					String pass = (String) req.getAttribute("password");
					if (confirmpassword.equals(pass)) {
						MD5Encoder md5 = new MD5Encoder();
						try {
							user.setPassword(md5.md5Encoder(pass));
							req.removeAttribute("password");
						} catch (NoSuchAlgorithmException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
					}
				}
				if (item.getFieldName().equals("role")) {
					int role = Integer.parseInt(item.getString("UTF-8"));
					user.setRole(role);
				}
				if (item.getFieldName().equals("gender")) {
					String gender = item.getString("UTF-8");
					user.setGender(gender);
				}
				if (item.getFieldName().equals("address")) {
					String address = item.getString("UTF-8");
					user.setAddress(address);
				}
				if (item.getFieldName().equals("phone")) {
					String phone = item.getString();
					user.setPhone(phone);
				}
				if (item.getFieldName().equals("datebirth")) {
					String datebirth = item.getString();
					user.setDatebirth(datebirth);
				}
				if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						final String UPLOAD = "E:\\Java\\HoaLanVN\\WebContent\\upload\\user";
						File UPLOAD_FOLDER = new File(UPLOAD);
						if (!UPLOAD_FOLDER.exists()) {
							UPLOAD_FOLDER.mkdir();
						}
						String name = item.getName();
						File UPLOAD_IMG = new File(UPLOAD + File.separator + name);
						if (!UPLOAD_IMG.exists()) {
							item.write(UPLOAD_IMG);
							user.setImage(name);
						} else {
							user.setImage(name);
						}
					}
				}
			}
			// lay thoi gian hien tai
			Date date = new Date();
			DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String date_created = dateformat.format(date);
			user.setDate_created(date_created);

			String status = "1";
			user.setStatus(status);

			if (user.getPassword() == null) {
				resp.sendRedirect(req.getContextPath() + "/admin/user/add?mess=password");
				System.out.println("mk k giong");
			}
			if (user.getUsername() == null) {
				resp.sendRedirect(req.getContextPath() + "/admin/user/add?mess=username");
				System.out.println("username ton tai");
			} else {
				userDao.addUser(user);
				resp.sendRedirect(req.getContextPath() + "/admin/user/add?mess=success");
				System.out.println("them thanh cong" + user.getUsername());
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
