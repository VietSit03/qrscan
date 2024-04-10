package project.qrscan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.qrscan.Entitiy.Product;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT id FROM product", nativeQuery = true)
    ArrayList<Long> getListIdProduct();
}
