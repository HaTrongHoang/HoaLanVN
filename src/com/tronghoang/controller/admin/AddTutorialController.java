package com.tronghoang.controller.admin;

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

import com.tronghoang.dao.CategoryDao;
import com.tronghoang.dao.TutorialDao;
import com.tronghoang.dao.impl.CategoryDaoImpl;
import com.tronghoang.dao.impl.TutorialDaoImpl;
import com.tronghoang.model.Category;
import com.tronghoang.model.Tutorial;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/admin/tutorial/add")
public class AddTutorialController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> categoryList = categoryDao.getCategory();
		req.setAttribute("categoryList", categoryList);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/addTutorial.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tao doi tuong luu file
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// set dia chi luu file
//		diskFileItemFactory.setRepository(new File("E:\\Java\\HoaLanVN\\WebContent\\upload\\content\\_thumbs"));

		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		Tutorial tutorial = new Tutorial();

		try {
			// doc request tu client gui len trong form upload
			List<FileItem> listFile = servletFileUpload.parseRequest(req);

			for (FileItem item : listFile) {
				if (item.getFieldName().equals("category_id")) {
					int category_id = Integer.parseInt(item.getString("UTF-8"));
					Category category = new Category();
					category.setId_category(category_id);
					tutorial.setCategory_id(category);
				}
				if (item.getFieldName().equals("title")) {
					String title = item.getString("UTF-8");
					tutorial.setTitle(title);
				}
				if (item.getFieldName().equals("thumbnail")) {
					// kiem tra dung luong file
					if (item.getSize() > 0)// neu co file
					{
						final String UPLOAD = "E:\\Java\\HoaLanVN\\WebContent\\upload\\content\\_thumbs";
						// kiem tra file ton tai neu k thi tao moi
						File UPLOAD_FOLDER = new File(UPLOAD);
						if (!UPLOAD_FOLDER.exists()) {
							UPLOAD_FOLDER.mkdir();
						}
						String name = item.getName();

						File UPLOAD_IMG = new File(UPLOAD + File.separator + name);
						if (!UPLOAD_IMG.exists()) {
							item.write(UPLOAD_IMG);
							tutorial.setThumbnail(name);
						} else {
							tutorial.setThumbnail(name);
						}

					}
				}
				if (item.getFieldName().equals("describe")) {
					String describe = item.getString("UTF-8");
					tutorial.setDescribe(describe);
				}
				if (item.getFieldName().equals("content")) {
					String str = item.getString("UTF-8");
					// mã hóa
//							byte[] strByte=str.getBytes();
//							String content=Base64.getEncoder().encodeToString(strByte);
//							System.out.println(content);
					// giải mã
//							byte[] decoded=Base64.getDecoder().decode(content);
//							String decod=new String(decoded);
//							System.out.println(decod);
					tutorial.setContent(str);
					System.out.println(tutorial.getContent());
				}
			}

		} catch (FileUploadException e) {
			System.out.println("loi upload thumb" + e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("loi upload thumb" + e);
		}
		// lay thoi gian hien tai
		Date date = new Date();
		DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String date_created = dateformat.format(date);
		tutorial.setDate_created(date_created);
		System.out.println(tutorial.getDate_created());

		String status = "1";
		tutorial.setStatus(status);
		System.out.println(tutorial.getStatus());

		int view = 0;
		tutorial.setView(view);
		System.out.println(tutorial.getView());

		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("loginAdmin");
		tutorial.setId_user(userLogin.getFullname());

		TutorialDao tutorialDao = new TutorialDaoImpl();
		tutorialDao.addTutorial(tutorial);
		resp.sendRedirect(req.getContextPath() + "/admin/tutorial?category_id="
				+ tutorial.getCategory_id().getId_category() + "&mess=addsuccess");
	}
}
