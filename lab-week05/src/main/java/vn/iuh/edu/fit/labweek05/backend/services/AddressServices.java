package vn.iuh.edu.fit.labweek05.backend.services;

import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.labweek05.frontend.models.Address;

@Service
public interface AddressServices {
    public Address addAddress(Address address);
}
