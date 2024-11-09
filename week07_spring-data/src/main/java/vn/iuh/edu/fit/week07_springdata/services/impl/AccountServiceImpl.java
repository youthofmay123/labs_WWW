package vn.iuh.edu.fit.week07_springdata.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.week07_springdata.models.Account;
import vn.iuh.edu.fit.week07_springdata.repositories.AccountRepository;
import vn.iuh.edu.fit.week07_springdata.services.AccountService;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;


    @Override
    public List<Account> findByBalanceGreaterThan(double balance, Pageable pageable) {
        return accountRepository.findByBalanceGreaterThan(balance, pageable);
    }

    @Override
    public Account findById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            return account.get();
        } else {
            return null;
        }
    }

    @Override
    public void addAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public void deleteAccount(Account account) {

    }
}
