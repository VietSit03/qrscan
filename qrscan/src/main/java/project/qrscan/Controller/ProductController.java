package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.qrscan.Service.ProductServiceImp;

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
}
