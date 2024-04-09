package project.qrscan.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.qrscan.Entitiy.Product;
import project.qrscan.Repository.*;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SnackRepository snackRepository;
    @Autowired
    private BeverageRepository beverageRepository;
    @Autowired
    private DryFoodRepository dryFoodRepository;
    @Autowired
    private IceCreamRepository iceCreamRepository;
    @Autowired
    private MilkRepository milkRepository;

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            switch (product.get().getType()) {
                case "Beverage" -> {
                    return ResponseEntity.status(HttpStatus.OK).body(beverageRepository.findById(id));
                }
                case "Dry Food" -> {
                    return ResponseEntity.status(HttpStatus.OK).body(dryFoodRepository.findById(id));
                }
                case "Ice Cream" -> {
                    return ResponseEntity.status(HttpStatus.OK).body(iceCreamRepository.findById(id));
                }
                case "Milk" -> {
                    return ResponseEntity.status(HttpStatus.OK).body(milkRepository.findById(id));
                }
                case "Snack" -> {
                    return ResponseEntity.status(HttpStatus.OK).body(snackRepository.findById(id));
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found product");
    }

    @Override
    public ResponseEntity<List<?>> listByType(String type) {
        switch (type) {
            case "beverage" -> {
                return ResponseEntity.status(HttpStatus.OK).body(beverageRepository.findAll());
            }
            case "dryfood" -> {
                return ResponseEntity.status(HttpStatus.OK).body(dryFoodRepository.findAll());
            }
            case "icecream" -> {
                return ResponseEntity.status(HttpStatus.OK).body(iceCreamRepository.findAll());
            }
            case "milk" -> {
                return ResponseEntity.status(HttpStatus.OK).body(milkRepository.findAll());
            }
            case "snack" -> {
                return ResponseEntity.status(HttpStatus.OK).body(snackRepository.findAll());
            }
            case "all" -> {
                return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
            }
        }
        throw new RuntimeException("Error");
    }

}
