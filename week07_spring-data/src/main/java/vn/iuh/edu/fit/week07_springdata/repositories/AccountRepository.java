package vn.iuh.edu.fit.week07_springdata.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iuh.edu.fit.week07_springdata.models.Account;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByBalanceGreaterThan(double balance, Pageable pageable);
}
