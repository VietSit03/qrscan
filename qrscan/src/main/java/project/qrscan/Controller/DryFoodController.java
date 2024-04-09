package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.qrscan.Entitiy.Beverage;
import project.qrscan.Entitiy.DryFood;
import project.qrscan.Repository.DryFoodRepository;

@RestController
@RequestMapping("/api/v1/dryfoods")
public class DryFoodController {
    @Autowired
    private DryFoodRepository dryFoodRepository;

    @PostMapping()
    public ResponseEntity<?> addDryFood(@RequestBody DryFood dryFood) {
        dryFoodRepository.save(dryFood);
        return ResponseEntity.status(HttpStatus.CREATED).body(dryFood);
    }
}
