package project.qrscan.Service.HistoryScan;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface HistoryScanService {
    public abstract ResponseEntity<Map<Long, Integer>> getTimesScanProduct();
    public abstract ResponseEntity<Map<Long, Integer>> getTimesScanProductInMonth(String year_month);
    public abstract ResponseEntity<Map<Long, Integer>> getTimesScanProductInYear(String year);
    public abstract ResponseEntity<?> scanQR(Long id);
}
