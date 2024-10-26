package vn.iuh.edu.fit.onthigiuaky_ver3.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iuh.edu.fit.onthigiuaky_ver3.models.LoaiThuoc;
import vn.iuh.edu.fit.onthigiuaky_ver3.repositories.LoaiThuocRepository;
import vn.iuh.edu.fit.onthigiuaky_ver3.services.LoaiThuocService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/loai_thuoc"})
public class LoaiThuocController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoaiThuocService loaiThuocService = new LoaiThuocRepository();
        String action = req.getParameter("action");
        switch (action){
            case "list-loai-thuoc":
            {
                List<LoaiThuoc> listLoaiThuoc = loaiThuocService.getAllLoaiThuoc();
                req.setAttribute("listLoaiThuoc", listLoaiThuoc);
                req.getRequestDispatcher("loaiThuoc.jsp").forward(req, resp);
                break;
            }
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoaiThuocService loaiThuocService = new LoaiThuocRepository();
        String action = req.getParameter("action");
        switch (action){
            case "them-loai-thuoc":
            {
                String tenLoaiThuoc = req.getParameter("tenLoaiThuoc");
                LoaiThuoc loaiThuoc = new LoaiThuoc();
                loaiThuoc.setTenLoai(tenLoaiThuoc);
                loaiThuocService.themLoaiThuoc(loaiThuoc);

                resp.sendRedirect("loai_thuoc?action=list-loai-thuoc");
                break;

            }

        }
    }
}
