package vn.iuh.edu.fit.frontend.controller;

import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import vn.iuh.edu.fit.frontend.models.ProductModel;

@WebServlet(name = "v ", value = "/controller")
public class Controller extends HttpServlet {
    @Inject
    private ProductModel productModel;
}
