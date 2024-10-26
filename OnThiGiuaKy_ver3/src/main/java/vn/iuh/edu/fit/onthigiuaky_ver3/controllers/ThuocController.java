package vn.iuh.edu.fit.onthigiuaky_ver3.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import vn.iuh.edu.fit.onthigiuaky_ver3.models.LoaiThuoc;
import vn.iuh.edu.fit.onthigiuaky_ver3.models.Thuoc;
import vn.iuh.edu.fit.onthigiuaky_ver3.repositories.LoaiThuocRepository;
import vn.iuh.edu.fit.onthigiuaky_ver3.repositories.ThuocRepository;
import vn.iuh.edu.fit.onthigiuaky_ver3.services.LoaiThuocService;
import vn.iuh.edu.fit.onthigiuaky_ver3.services.ThuocService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/thuoc"})
public class ThuocController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThuocService thuocService = new ThuocRepository();
        LoaiThuocService loaiThuocService = new LoaiThuocRepository();
        String action = req.getParameter("action");
        switch (action){
            case "list-thuoc":
            {
                List<Thuoc> listThuoc = thuocService.getAllThuoc();
                List<LoaiThuoc> listLoaiThuoc = loaiThuocService.getAllLoaiThuoc();
                req.setAttribute("listThuoc", listThuoc);
                req.setAttribute("listLoaiThuoc", listLoaiThuoc);
                req.getRequestDispatcher("thuoc.jsp").forward(req, resp);
                break;
            }

            case "them-thuoc": {
                List<LoaiThuoc> loaiThuocs = loaiThuocService.getAllLoaiThuoc();
                req.setAttribute("loaiThuocs", loaiThuocs);
                req.getRequestDispatcher("themThuoc.jsp").forward(req, resp);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ThuocService thuocService = new ThuocRepository();
        LoaiThuocService loaiThuocService = new LoaiThuocRepository();
        String action = req.getParameter("action");
        System.out.println("action: "+ action);
        switch (action){
            case "them-thuoc":{

                String name = req.getParameter("tenThuoc");
                double price = Double.parseDouble(req.getParameter("giaThuoc"));
                int year = Integer.parseInt(req.getParameter("namSanXuat"));
                String tenLoaiThuoc = req.getParameter("tenLoaiThuoc");
                LoaiThuoc loaiThuoc = new LoaiThuoc();
                for(LoaiThuoc l: loaiThuocService.getAllLoaiThuoc()){
                    if(l.getTenLoai().equals(tenLoaiThuoc)){
                        loaiThuoc = l;
                    }
                }

                Thuoc thuoc = new Thuoc(name, price, year, loaiThuoc);

                boolean check = thuocService.addThuoc(thuoc);

                if(!check)
                {
                    System.out.println("Thuoc khong duoc them");
                    resp.sendRedirect("thuoc?action=list-thuoc");
                    break;
                }
                System.out.println("Thuoc da duoc them");
                resp.sendRedirect("thuoc?action=list-thuoc");
                break;
            }
            case "list-thuoc-theo-loai":
            {
                String selectLoaiThuoc = req.getParameter("select-loai-thuoc");
                List<Thuoc> listThuoc = thuocService.findThuocByLoaiThuoc(selectLoaiThuoc);
                List<LoaiThuoc> listLoaiThuoc = loaiThuocService.getAllLoaiThuoc();
                req.setAttribute("listThuoc", listThuoc);
                req.setAttribute("listLoaiThuoc", listLoaiThuoc);
                req.getRequestDispatcher("thuoc.jsp").forward(req, resp);


                break;
            }
        }
    }
}
