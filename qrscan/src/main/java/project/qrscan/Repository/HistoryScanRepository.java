package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.qrscan.Entitiy.HistoryScan;

@Repository
public interface HistoryScanRepository extends JpaRepository<HistoryScan, Long> {
}
