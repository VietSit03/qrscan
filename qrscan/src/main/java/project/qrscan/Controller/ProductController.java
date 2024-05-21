package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.qrscan.Repository.ProductRepository;
import project.qrscan.Service.Product.ProductServiceImp;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) {
        return productServiceImp.findById(id);
    }

    @GetMapping("/types")
    public ResponseEntity<?> listTypesProduct() {
        return productServiceImp.listTypesProduct();
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<?> listProductsByType(@PathVariable String type) {
        return productServiceImp.listProductsByType(type);
    }

    @GetMapping("next_id")
    public ResponseEntity<?> getNextId() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.getNextId()+1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return productServiceImp.deleteProduct(id);
    }
}
