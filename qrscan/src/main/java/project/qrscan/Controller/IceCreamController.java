package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.qrscan.Entitiy.IceCream;
import project.qrscan.Entitiy.IceCream;
import project.qrscan.Repository.IceCreamRepository;
import project.qrscan.Service.T.IceCreamService;

@RestController
@RequestMapping("/api/v1/ice_creams")
public class IceCreamController {
    @Autowired
    private IceCreamService iceCreamService;

    public ResponseEntity<?> addIceCream(@RequestBody IceCream iceCream) {
        return iceCreamService.create(iceCream);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIceCream(@PathVariable Long id, @RequestBody IceCream iceCream) {
        return iceCreamService.update(id, iceCream);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIceCream(@PathVariable Long id) {
        return iceCreamService.delete(id);
    }
}
