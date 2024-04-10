package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.qrscan.Entitiy.HistoryScan;

@Repository
public interface HistoryScanRepository extends JpaRepository<HistoryScan, Long> {
    @Query(value = "SELECT COUNT(product_id) FROM history_scan WHERE product_id = :productId ", nativeQuery = true)
    Integer getTimesScanProduct(@Param("productId") Long productId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM history_scan WHERE product_id = :productId", nativeQuery = true)
    void deleteHistoryScan(@Param("productId") Long productId);

}
