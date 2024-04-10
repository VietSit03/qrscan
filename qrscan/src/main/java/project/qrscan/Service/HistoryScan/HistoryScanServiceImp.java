package project.qrscan.Service.HistoryScan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.qrscan.Repository.HistoryScanRepository;
import project.qrscan.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class HistoryScanServiceImp implements HistoryScanService{

    @Autowired
    private HistoryScanRepository historyScanRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<Map<Long, Integer>> getTimesScanProduct() {
        ArrayList<Long> listIdProduct = productRepository.getListIdProduct();
        Map<Long, Integer> map = new HashMap<>();
        for (Long product_id:listIdProduct) {
            map.put(product_id, historyScanRepository.getTimesScanProduct(product_id));
        }
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @Override
    public ResponseEntity<Map<Long, Integer>> getTimesScanProductInMonth(String year_month) {
        ArrayList<Long> listIdProduct = productRepository.getListIdProduct();
        Map<Long, Integer> map = new HashMap<>();
        for (Long product_id:listIdProduct) {
            map.put(product_id, historyScanRepository.getTimesScanProductInMonth(year_month, product_id));
        }
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
