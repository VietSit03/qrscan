package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.qrscan.Entitiy.IceCream;
import project.qrscan.Repository.IceCreamRepository;

@RestController
@RequestMapping("/api/v1/icecreams")
public class IceCreamController {
    @Autowired
    private IceCreamRepository iceCreamRepository;

    public ResponseEntity<?> addIceCream(@RequestBody IceCream iceCream) {
        iceCreamRepository.save(iceCream);
        return ResponseEntity.status(HttpStatus.CREATED).body(iceCream);
    }
}
