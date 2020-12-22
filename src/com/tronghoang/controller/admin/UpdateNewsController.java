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

import com.tronghoang.dao.NewsDao;
import com.tronghoang.dao.impl.NewsDaoImpl;
import com.tronghoang.model.News;

@WebServlet(urlPatterns = "/admin/news/update")
public class UpdateNewsController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id_news = Integer.parseInt(req.getParameter("id_news"));
		NewsDao newsDao = new NewsDaoImpl();
		News news = newsDao.getNewsId(id_news);
		req.setAttribute("newsUpdate", news);
		System.out.println(news.getContent());
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/updateNews.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tao doi tuong luu file
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//// set dia chi luu file
		factory.setRepository(new File("E:\\Java\\HoaLanVN\\WebContent\\upload\\content\\_thumbs"));

		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

		News news = new News();
		NewsDao newsDao = new NewsDaoImpl();
		int id_news = Integer.parseInt(req.getParameter("id_news"));
		news.setId_news(id_news);
		// doc request tu client gui len trong form upload
		try {
			List<FileItem> itemList = servletFileUpload.parseRequest(req);
			for (FileItem item : itemList) {
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
							news.setThumbnail(thumb);
						} else {
							news.setThumbnail(thumb);
						}
					} else {
						News thumb = newsDao.getNewsId(id_news);
						news.setThumbnail(thumb.getThumbnail());
					}
				}
				if (item.getFieldName().equals("title")) {
					String title = item.getString("UTF-8");
					news.setTitle(title);
				}
				if (item.getFieldName().equals("describe")) {
					String describe = item.getString("UTF-8");
					news.setDescribe(describe);
				}
				if (item.getFieldName().equals("content")) {
					String content = item.getString("UTF-8");
					System.out.println(item.getString());
					news.setContent(content);
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newsDao.updateNews(news);
		resp.sendRedirect(req.getContextPath() + "/admin/news?mess=update");
	}
}
