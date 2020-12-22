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

import com.tronghoang.dao.CategoryDao;
import com.tronghoang.dao.TutorialDao;
import com.tronghoang.dao.impl.CategoryDaoImpl;
import com.tronghoang.dao.impl.TutorialDaoImpl;
import com.tronghoang.model.Category;
import com.tronghoang.model.Tutorial;

@WebServlet(urlPatterns = "/admin/tutorial/update")
public class UpdateTutorialController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_tutorial = Integer.parseInt(req.getParameter("id_tutorial"));
		TutorialDao tutorialDao = new TutorialDaoImpl();
		Tutorial tutorial = tutorialDao.getTutorialId(id_tutorial);
		req.setAttribute("tutorialUpdate", tutorial);
		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> categoryList = categoryDao.getCategory();
		req.setAttribute("categoryList", categoryList);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updateTutorial.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tao doi tuong luu file
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//// set dia chi luu file
//		factory.setRepository(new File("E:\\Java\\HoaLanVN\\WebContent\\upload\\content\\_thumbs"));

		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

		Tutorial tutorial = new Tutorial();
		TutorialDao tutorialDao = new TutorialDaoImpl();
		int id_tutorial = Integer.parseInt(req.getParameter("id_tutorial"));
		tutorial.setId_tutorial(id_tutorial);
		// doc request tu client gui len trong form upload
		try {
			List<FileItem> itemList = servletFileUpload.parseRequest(req);
			for (FileItem item : itemList) {
				if (item.getFieldName().equals("category_id")) {
					int category_id = Integer.parseInt(item.getString("UTF-8"));
					Category category = new Category();
					category.setId_category(category_id);
					tutorial.setCategory_id(category);
				}
				if (item.getFieldName().equals("thumb")) {

					if (item.getSize() > 0) {
						final String UPLOAD = "E:\\Java\\HoaLanVN\\WebContent\\upload\\content\\_thumbs";
						File UPLOAD_FOLDER = new File(UPLOAD);
						if (!UPLOAD_FOLDER.exists()) {
							UPLOAD_FOLDER.mkdir();
						}
						String thumb = item.getName();
						File UPLOAD_IMG = new File(UPLOAD + File.separator + thumb);
						if (!UPLOAD_IMG.exists()) {
							item.write(UPLOAD_IMG);
							tutorial.setThumbnail(thumb);
						} else {
							tutorial.setThumbnail(thumb);
						}
					} else {
						Tutorial thumb = tutorialDao.getTutorialId(id_tutorial);
						tutorial.setThumbnail(thumb.getThumbnail());
					}
				}
				if (item.getFieldName().equals("title")) {
					String title = item.getString("UTF-8");
					tutorial.setTitle(title);
				}
				if (item.getFieldName().equals("describe")) {
					String describe = item.getString("UTF-8");
					tutorial.setDescribe(describe);
				}
				if (item.getFieldName().equals("content")) {
					String content = item.getString("UTF-8");
					System.out.println(item.getString());
					tutorial.setContent(content);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tutorialDao.updateTutorial(tutorial);
		resp.sendRedirect(req.getContextPath() + "/admin/tutorial?category_id="
				+ tutorial.getCategory_id().getId_category() + "&mess=update");
	}
}
