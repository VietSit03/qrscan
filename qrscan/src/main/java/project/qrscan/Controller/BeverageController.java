package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.qrscan.Entitiy.Beverage;
import project.qrscan.Repository.BeverageRepository;

@RestController
@RequestMapping("/api/v1/beverages")
public class BeverageController {
    @Autowired
    private BeverageRepository beverageRepository;

    @PostMapping()
    public ResponseEntity<?> addBeverage(@RequestBody Beverage beverage) {
        beverageRepository.save(beverage);
        return ResponseEntity.status(HttpStatus.CREATED).body(beverage);
    }

}
