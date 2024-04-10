package project.qrscan.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.qrscan.Service.T.BeverageService;

@RestController
@RequestMapping("/api/v1/history_scans")
public class HistoryScanController {
    @Autowired
    private BeverageService beverageService;
}
