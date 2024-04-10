package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.qrscan.Service.Product.ProductServiceImp;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        return productServiceImp.findById(id);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<?> listProductsByType(@PathVariable String type) {
        return productServiceImp.listByType(type);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return productServiceImp.deleteProduct(id);
    }
}
