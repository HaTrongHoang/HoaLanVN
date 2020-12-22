package com.tronghoang.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.tronghoang.dao.UserDao;
import com.tronghoang.dao.impl.UserDaoImpl;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/admin/user/update")
public class UpdateUserController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_user = Integer.parseInt(req.getParameter("id_user"));
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserId(id_user);
		req.setAttribute("userUpdate", user);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updateUser.jsp");
		requestDispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tao doi tuong luu file
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//// set dia chi luu file
		factory.setRepository(new File("E:\\Java\\HoaLanVN\\WebContent\\upload\\user"));

		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

		User user = new User();
		UserDao userDao = new UserDaoImpl();
		int id_user = Integer.parseInt(req.getParameter("id_user"));
		user.setId_user(id_user);
		// doc request tu client gui len trong form upload
		try {
			List<FileItem> itemList = servletFileUpload.parseRequest(req);
			for (FileItem item : itemList) {
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
					} else {
						User img = userDao.getUserId(id_user);
						user.setImage(img.getImage());
					}
				}
				if (item.getFieldName().equals("fullname")) {
					String fullname = item.getString("UTF-8");
					user.setFullname(fullname);
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
					System.out.println(item.getString());
					user.setAddress(address);
				}
				if (item.getFieldName().equals("phone")) {
					String phone = item.getString("UTF-8");
					user.setPhone(phone);
				}
				if (item.getFieldName().equals("datebirth")) {
					String datebirth = item.getString();
					user.setDatebirth(datebirth);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user.getFullname());
		System.out.println(user.getRole());
		System.out.println(user.getGender());
		System.out.println(user.getAddress());
		System.out.println(user.getPhone());
		System.out.println(user.getDatebirth());
		System.out.println(user.getImage());
		System.out.println(user.getId_user());
		userDao.updateUser(user);
		resp.sendRedirect(req.getContextPath() + "/admin/user?mess=update");
	}
}
