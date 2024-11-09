package vn.iuh.edu.fit.week07_springdata.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.week07_springdata.models.Account;

import java.util.List;

@Service
public interface AccountService {
    public List<Account> findByBalanceGreaterThan(double balance, Pageable pageable);
    public Account findById(Long id);
    public void addAccount(Account account);
    public void updateAccount(Account account);
    public void deleteAccount(Account account);
}
