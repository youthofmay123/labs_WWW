package vn.iuh.edu.fit.week07_springdata.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.iuh.edu.fit.week07_springdata.models.Account;
import vn.iuh.edu.fit.week07_springdata.services.impl.AccountServiceImpl;

import java.lang.reflect.Array;

@RestController
public class AccountResource {
    @Autowired
    AccountServiceImpl accountServiceImpl;

    @GetMapping("find/{id}")
    public Account findById(Long id)
    {
        return accountServiceImpl.findById(id);
    }

    @GetMapping
    public Array addAccount(){
        return null;
    }
}
