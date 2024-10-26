package vn.com.iuh.fit.backend.api;

import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import vn.com.iuh.fit.backend.business.ProductBeanRemote;
import vn.com.iuh.fit.backend.repositories.entities.Product;

@Path("/products")
public class ProductResource {

    @EJB
    private ProductBeanRemote productBean;

    @GET
    public Response getAllProducts() {
        return Response.ok(productBean.findAll()).build();
    }

    @GET
    @Path("/{id}")
    public Response getProductById(@PathParam("id") int id) {
        return Response.ok(productBean.findById(id)).build();
    }

    @POST
    public Response create(Product product) {
        productBean.add(product);
        return Response.ok(product).build();
    }
}
