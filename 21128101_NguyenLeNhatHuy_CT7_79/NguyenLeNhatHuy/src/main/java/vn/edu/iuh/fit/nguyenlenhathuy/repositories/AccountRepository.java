package vn.edu.iuh.fit.nguyenlenhathuy.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.nguyenlenhathuy.models.Account;
import vn.edu.iuh.fit.nguyenlenhathuy.services.AccountService;

import java.util.List;

public class AccountRepository implements AccountService {
    EntityManager em;
    public AccountRepository() {
        em = Persistence.createEntityManagerFactory("HuyNguyen").createEntityManager();
    }

    @Override
    public boolean addAccount(Account account) {
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(account);
            tx.commit();
            return true;
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Account> getAll() {
        return em.createQuery("Select a from Account a").getResultList();
    }

    @Override
    public List<Account> getListWithBalance(Double min) {
        return em.createQuery("Select a from Account a where a.amount <= :min")
                .setParameter("min", min)
                .getResultList();
    }

    @Override
    public List<Account> getListWithCity(String address) {
        return em.createQuery("Select a from Account a where a.ownerAddress = :address")
                .setParameter("address", address)
                .getResultList();
    }

    @Override
    public List<Account> getListWithOwnerName(String ownerName) {
        return em.createQuery("Select a from Account a where a.owner_name = :ownerName")
                .setParameter("ownerName", ownerName)
                .getResultList();
    }

    @Override
    public boolean PhatSinh(String soTaiKhoan) {
        return false;
    }

    public static void main(String[] args) {
        AccountService accountService = new AccountRepository();
        for(Account a : accountService.getListWithCity("Tay Ninh"))
        {
            System.out.println(a);
        }
    }
}
