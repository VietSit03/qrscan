package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.qrscan.Entitiy.Snack;
import project.qrscan.Repository.SnackRepository;

@RestController
@RequestMapping("/api/v1/snacks")
public class SnackController {
    @Autowired
    private SnackRepository snackRepository;

    @PostMapping()
    public ResponseEntity<?> addSnack(@RequestBody Snack snack) {
        snackRepository.save(snack);
        return ResponseEntity.status(HttpStatus.CREATED).body(snack);
    }

}
