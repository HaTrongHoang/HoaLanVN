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

import com.tronghoang.dao.NewsDao;
import com.tronghoang.dao.impl.NewsDaoImpl;
import com.tronghoang.model.News;
import com.tronghoang.model.User;

@WebServlet(urlPatterns = "/admin/news/add")
public class AddNewsController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/addNews.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tao doi tuong luu file
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		// set dia chi luu file
		diskFileItemFactory.setRepository(new File("E:\\Java\\HoaLanVN\\WebContent\\upload\\content\\_thumbs"));

		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		News news = new News();

		try {
			// doc request tu client gui len trong form upload
			List<FileItem> listFile = servletFileUpload.parseRequest(req);

			for (FileItem item : listFile) {
				if (item.getFieldName().equals("title")) {
					String title = item.getString("UTF-8");
					news.setTitle(title);
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
							news.setThumbnail(name);
						} else {
							news.setThumbnail(name);
						}

					}
				}
				if (item.getFieldName().equals("describe")) {
					String describe = item.getString("UTF-8");
					news.setDescribe(describe);
				}
				if (item.getFieldName().equals("content")) {
					String str = item.getString("UTF-8");
					// mã hóa
//					byte[] strByte=str.getBytes();
//					String content=Base64.getEncoder().encodeToString(strByte);
//					System.out.println(content);
					// giải mã
//					byte[] decoded=Base64.getDecoder().decode(content);
//					String decod=new String(decoded);
//					System.out.println(decod);
					news.setContent(str);
					System.out.println(news.getContent());
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
		news.setDate_created(date_created);
		System.out.println(news.getDate_created());

		String status = "1";
		news.setStatus(status);
		System.out.println(news.getStatus());

		int view = 0;
		news.setView(view);
		System.out.println(news.getView());

		HttpSession session = req.getSession();
		User userLogin = (User) session.getAttribute("loginAdmin");
		news.setId_user(userLogin.getFullname());

		NewsDao newDao = new NewsDaoImpl();
		newDao.addNews(news);
		resp.sendRedirect(req.getContextPath() + "/admin/news?mess=addsuccess");
	}
}
