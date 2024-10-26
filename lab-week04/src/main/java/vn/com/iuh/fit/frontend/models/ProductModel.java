package vn.com.iuh.fit.frontend.models;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.com.iuh.fit.backend.repositories.entities.Product;

import java.util.List;

public class ProductModel {

    private final String ADD_URL = "http://localhost:8080/week04-1.0-SNAPSHOT/api/products";

    public void createProduct(Product product) {
        // Gọi API để tạo mới sản phẩm
        try (Client client = ClientBuilder.newClient()) {
            WebTarget ws = client.target(ADD_URL);
            Response response = ws.request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(product, MediaType.APPLICATION_JSON));
            // Kiểm tra kết quả trả về
            if (response.getStatus() == 201) {
                System.out.println("Product created successfully");
            } else {
                System.out.println("Failed to create product: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        // Gọi API để lấy danh sách sản phẩm
        try (Client client = ClientBuilder.newClient()) {
            // Tạo đối tượng WebTarget để gọi API
            WebTarget ws = client.target(ADD_URL);
            // Gọi API
            Response response = ws.request(MediaType.APPLICATION_JSON).get();
            if (response.getStatus() == 200) {
                // Sử dụng GenericType để ánh xạ JSON thành danh sách Product
                return response.readEntity(new GenericType<List<Product>>() {});
            } else {
                System.out.println("Failed to get products: " + response.getStatus());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
