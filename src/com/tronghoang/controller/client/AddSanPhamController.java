package com.tronghoang.controller.client;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.tronghoang.dao.ProductDao;
import com.tronghoang.dao.impl.ProductDaoImpl;
import com.tronghoang.model.Product;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/traodoi/shop/gianhang/add")
public class AddSanPhamController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/addSanPham.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("name")) {
					product.setName(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("category")) {
					product.setCategory(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("price")) {
					product.setPrice(Float.parseFloat(item.getString("UTF-8")));
				} else if (item.getFieldName().equals("des")) {
					product.setDes(item.getString("UTF-8"));

				} else if (item.getFieldName().equals("amount")) {
					product.setAmount(Integer.parseInt(item.getString("UTF-8")));

				} else if (item.getFieldName().equals("image")) {
					if (item.getSize() > 0) {
						final String UPLOAD = "E:\\Java\\HoaLanVN\\WebContent\\upload\\product";
						File UPLOAD_FOLDER = new File(UPLOAD);
						if (!UPLOAD_FOLDER.exists()) {
							UPLOAD_FOLDER.mkdir();
						}
						String name = item.getName();
						File UPLOAD_IMG = new File(UPLOAD + File.separator + name);
						if (!UPLOAD_IMG.exists()) {
							item.write(UPLOAD_IMG);
							product.setImage(name);
						} else {
							product.setImage(name);
						}
					}
				}
			}
			Date date = new Date();
			DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String date_created = dateformat.format(date);
			product.setDate_created(date_created);

			HttpSession session = req.getSession();
			User userLogin = (User) session.getAttribute("loginClient");
			User user = new User();
			user.setId_user(userLogin.getId_user());
			product.setUser(user);

			String status = "1";
			product.setStatus(status);

			ProductDao productDao = new ProductDaoImpl();
			productDao.add(product);
			resp.sendRedirect(req.getContextPath() + "/traodoi/shop/gianhang?mess=success");
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
