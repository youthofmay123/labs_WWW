package vn.com.iuh.fit.frontend.controllers;

import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.com.iuh.fit.backend.repositories.entities.Product;
import vn.com.iuh.fit.frontend.models.ProductModel;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "controller", value = "/controller")
public class Controllers extends HttpServlet {

    @Inject
    private ProductModel productModel;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equalsIgnoreCase("add")) {
            String name = req.getParameter("name");
            String desc = req.getParameter("desc");
            String imgPath = req.getParameter("imgPath");
            HttpSession session = req.getSession();
            List<Product> products = productModel.getAllProducts();
            session.setAttribute("products", products);
            productModel.createProduct(new Product(name, desc, imgPath));
            RequestDispatcher dispatcher = req.getRequestDispatcher("ListProductView.jsp");
            dispatcher.forward(req, resp);
        } else if (action.equalsIgnoreCase("list")) {
            List<Product> products = productModel.getAllProducts();
            HttpSession session = req.getSession();
            session.setAttribute("products", products);
            RequestDispatcher dispatcher = req.getRequestDispatcher("ListProductView.jsp");
            dispatcher.forward(req, resp);
        } else if(action.equalsIgnoreCase("goAdd")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("AddProductView.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
