package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.qrscan.Entitiy.Milk;
import project.qrscan.Repository.MilkRepository;

@RestController
@RequestMapping("api/v1/milks")
public class MilkController {
    @Autowired
    private MilkRepository milkRepository;

    public ResponseEntity<?> addMilk(@RequestBody Milk milk) {
        milkRepository.save(milk);
        return ResponseEntity.status(HttpStatus.CREATED).body(milk);
    }
}
