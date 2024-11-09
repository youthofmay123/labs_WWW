package vn.edu.iuh.fit.nguyenlenhathuy.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.nguyenlenhathuy.models.Account;
import vn.edu.iuh.fit.nguyenlenhathuy.repositories.AccountRepository;
import vn.edu.iuh.fit.nguyenlenhathuy.services.AccountService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/account"})
public class AccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountRepository();
        String action = req.getParameter("action");

        switch (action)
        {
            case "list-all":
            {
                req.setAttribute("listAccount", accountService.getAll());
                req.getRequestDispatcher("account.jsp").forward(req, resp);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountRepository();
        String action = req.getParameter("action");

        switch (action)
        {
            case "loc-danh-sach":
            {
                List<Account> list = new ArrayList<Account>();
                String tieuChi = req.getParameter("luaChon");
                if(tieuChi.equals("soTien"))
                {
                    Double amount = 0.0;
                    try{
                        amount = Double.parseDouble(req.getParameter("text"));
                    } catch (Exception e){
                        e.printStackTrace();
                        System.out.println("Ban phai nhap so!!!");
                    }
                    list = accountService.getListWithBalance(amount);

                } else if (tieuChi.equals("tenChuTK")) {
                    String ownername = req.getParameter("text");
                    list = accountService.getListWithOwnerName(ownername);
                }
                if(req.getParameter("text").trim().equals(""))
                {
                    list=accountService.getAll();
                }
                req.setAttribute("listAccount", list);
                req.getRequestDispatcher("account.jsp").forward(req, resp);
                break;
            }
            case "them-tai-khoan":
            {
                String accountNumber = req.getParameter("accountNumber");
                String ownerName = req.getParameter("ownerName");
                String cardNumber = req.getParameter("cardNumber");
                String ownerAddress = req.getParameter("ownerAddress");
                Double amount = 0.0;
                try{
                    amount = Double.parseDouble(req.getParameter("amount"));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    System.out.println("Amount phai la so");
                }

                Account account = new Account(accountNumber, ownerName, cardNumber, ownerAddress, amount);
                boolean check = accountService.addAccount(account);
                if(check)
                {
                    System.out.println("Them thanh cong");
                }
                else {
                    System.out.println("Them that bai");
                }
                resp.sendRedirect("account?action=list-all");
                break;
            }
        }
    }
}
