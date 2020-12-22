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

import com.tronghoang.dao.BannerDao;
import com.tronghoang.dao.impl.BannerDaoImpl;
import com.tronghoang.model.Banner;

@WebServlet(urlPatterns = "/admin/banner")
public class BannerController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BannerDao bannerDao = new BannerDaoImpl();
		Banner banner = bannerDao.get(1);
		req.setAttribute("banner", banner);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/banner.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// tao doi tuong luu file
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//// set dia chi luu file
		factory.setRepository(new File("E:\\Java\\HoaLanVN\\WebContent\\upload\\banner"));

		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);

		Banner banner = new Banner();
		BannerDao bannerDao = new BannerDaoImpl();
		banner.setId(1);
		// doc request tu client gui len trong form upload
		try {
			List<FileItem> itemList = servletFileUpload.parseRequest(req);
			for (FileItem item : itemList) {
				if (item.getFieldName().equals("image1")) {

					if (item.getSize() > 0) {
						final String UPLOAD = "E:\\Java\\HoaLanVN\\WebContent\\upload\\banner";
						File UPLOAD_FOLDER = new File(UPLOAD);
						if (!UPLOAD_FOLDER.exists()) {
							UPLOAD_FOLDER.mkdir();
						}
						String name = item.getName();
						File UPLOAD_IMG = new File(UPLOAD + File.separator + name);
						if (!UPLOAD_IMG.exists()) {
							item.write(UPLOAD_IMG);
							banner.setImage1(name);
						} else {
							banner.setImage1(name);
						}
					} else {
						Banner img = bannerDao.get(1);
						banner.setImage1(img.getImage1());
					}
				}
				if (item.getFieldName().equals("image2")) {

					if (item.getSize() > 0) {
						final String UPLOAD = "E:\\Java\\HoaLanVN\\WebContent\\upload\\banner";
						File UPLOAD_FOLDER = new File(UPLOAD);
						if (!UPLOAD_FOLDER.exists()) {
							UPLOAD_FOLDER.mkdir();
						}
						String name = item.getName();
						File UPLOAD_IMG = new File(UPLOAD + File.separator + name);
						if (!UPLOAD_IMG.exists()) {
							item.write(UPLOAD_IMG);
							banner.setImage2(name);
						} else {
							banner.setImage2(name);
						}
					} else {
						Banner img = bannerDao.get(1);
						banner.setImage2(img.getImage2());
					}
				}
				if (item.getFieldName().equals("image3")) {

					if (item.getSize() > 0) {
						final String UPLOAD = "E:\\Java\\HoaLanVN\\WebContent\\upload\\banner";
						File UPLOAD_FOLDER = new File(UPLOAD);
						if (!UPLOAD_FOLDER.exists()) {
							UPLOAD_FOLDER.mkdir();
						}
						String name = item.getName();
						File UPLOAD_IMG = new File(UPLOAD + File.separator + name);
						if (!UPLOAD_IMG.exists()) {
							item.write(UPLOAD_IMG);
							banner.setImage3(name);
						} else {
							banner.setImage3(name);
						}
					} else {
						Banner img = bannerDao.get(1);
						banner.setImage3(img.getImage3());
					}
				}
			}

		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(banner.getImage1());
		System.out.println(banner.getId());
		bannerDao.updateBanner(banner);
		resp.sendRedirect(req.getContextPath() + "/admin/banner");
	}
}
