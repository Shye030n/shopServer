package org.sh.shopserver.repository;

import org.sh.shopserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
