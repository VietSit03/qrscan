package project.qrscan.Service.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.qrscan.Entitiy.*;
import project.qrscan.Repository.*;
import project.qrscan.Service.HistoryScan.HistoryScanServiceImp;
import project.qrscan.Service.Image.ImageService;
import project.qrscan.Service.T.*;

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
    @Autowired
    private ImageService imageService;
    @Autowired
    private HistoryScanRepository historyScanRepository;

    @Override
    public ResponseEntity<?> findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            switch (product.get().getType().trim().toLowerCase()) {
                case "beverage" -> {
                    return ResponseEntity.status(HttpStatus.OK).body(beverageRepository.findById(id));
                }
                case "dry food" -> {
                    return ResponseEntity.status(HttpStatus.OK).body(dryFoodRepository.findById(id));
                }
                case "ice cream" -> {
                    return ResponseEntity.status(HttpStatus.OK).body(iceCreamRepository.findById(id));
                }
                case "milk" -> {
                    return ResponseEntity.status(HttpStatus.OK).body(milkRepository.findById(id));
                }
                case "snack" -> {
                    return ResponseEntity.status(HttpStatus.OK).body(snackRepository.findById(id));
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found product id: "+id);
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
        throw new RuntimeException("Not found type product");
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            switch (product.get().getType().trim().toLowerCase()) {
                case "beverage" -> {
                    Optional<Beverage> beverage = beverageRepository.findById(id);
                    if (beverage.isEmpty()) {
                        throw new RuntimeException("Not found beverage id: " + id);
                    }
                    imageService.deleteImage(id);
                    historyScanRepository.deleteHistoryScan(id);
                    beverageRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.OK).body(beverage);
                }
                case "dry food" -> {
                    Optional<DryFood> dryFood = dryFoodRepository.findById(id);
                    if (dryFood.isEmpty()) {
                        throw new RuntimeException("Not found dry food id: " + id);
                    }
                    imageService.deleteImage(id);
                    historyScanRepository.deleteHistoryScan(id);
                    dryFoodRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.OK).body(dryFood);
                }
                case "ice cream" -> {
                    Optional<IceCream> iceCream = iceCreamRepository.findById(id);
                    if (iceCream.isEmpty()) {
                        throw new RuntimeException("Not found ice cream id: " + id);
                    }
                    imageService.deleteImage(id);
                    historyScanRepository.deleteHistoryScan(id);
                    iceCreamRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.OK).body(iceCream);
                }
                case "milk" -> {
                    Optional<Milk> milk = milkRepository.findById(id);
                    if (milk.isEmpty()) {
                        throw new RuntimeException("Not found milk id: " + id);
                    }
                    imageService.deleteImage(id);
                    historyScanRepository.deleteHistoryScan(id);
                    milkRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.OK).body(milk);
                }
                case "snack" -> {
                    Optional<Snack> snack = snackRepository.findById(id);
                    if (snack.isEmpty()) {
                        throw new RuntimeException("Not found snack id: " + id);
                    }
                    imageService.deleteImage(id);
                    historyScanRepository.deleteHistoryScan(id);
                    snackRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.OK).body(snack);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found product id: "+id);
    }

}
