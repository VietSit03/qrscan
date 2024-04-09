package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.qrscan.Entitiy.ImageProduct;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageProduct, Long> {
    Optional<ImageProduct> findByName(String name);
}
