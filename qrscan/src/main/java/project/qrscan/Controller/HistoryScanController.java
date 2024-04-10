package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.qrscan.Service.HistoryScan.HistoryScanService;
import project.qrscan.Service.HistoryScan.HistoryScanServiceImp;
import project.qrscan.Service.T.BeverageService;

@RestController
@RequestMapping("/api/v1/history_scans")
public class HistoryScanController {
    @Autowired
    private HistoryScanServiceImp historyScanServiceImp;

    @GetMapping
    public ResponseEntity<?> getTimesScanProduct() {
        return historyScanServiceImp.getTimesScanProduct();
    }

    @GetMapping("/{year_month}")
    public ResponseEntity<?> getTimesScanProductInMonth(@PathVariable String year_month) {
        return historyScanServiceImp.getTimesScanProductInMonth(year_month);
    }
}
