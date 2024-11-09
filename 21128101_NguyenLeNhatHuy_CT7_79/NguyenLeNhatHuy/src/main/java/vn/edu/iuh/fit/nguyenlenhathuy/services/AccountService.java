package vn.edu.iuh.fit.nguyenlenhathuy.services;

import vn.edu.iuh.fit.nguyenlenhathuy.models.Account;

import java.util.List;

public interface AccountService {
    public boolean addAccount(Account account);
    public List<Account> getAll();
    public List<Account> getListWithBalance(Double min);
    public List<Account> getListWithCity(String address);
    public List<Account> getListWithOwnerName(String ownerName);

    public boolean PhatSinh(String soTaiKhoan);
}
