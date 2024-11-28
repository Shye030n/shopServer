package org.sh.shopserver.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.sh.shopserver.dto.PurchaseDTO;
import org.sh.shopserver.model.Product;
import org.sh.shopserver.model.Purchase;
import org.sh.shopserver.model.User;
import org.sh.shopserver.repository.ProductRepository;
import org.sh.shopserver.repository.PurchaseRepository;
import org.sh.shopserver.repository.UserRepository;
import org.sh.shopserver.repository.projection.PurchaseItem;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Log4j2
public class PurchaseServiceImpl implements PurchaseService{
    private final PurchaseRepository purchaseRepositroy;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public Purchase savePurchase(PurchaseDTO purchaseDTO) {
        Purchase purchase = Purchase.builder()
                .quantity(purchaseDTO.getQuantity())
                .build();

        User user=userRepository.findByUsername(purchaseDTO.getUsername());
        Product product=productRepository.findById(purchaseDTO.getProductId()).orElseThrow();

        purchase.setUser(user);
        purchase.setProduct(product);
        purchase.setPurchaseTime(LocalDateTime.now());

        Purchase savedPurchase=purchaseRepositroy.save(purchase);
        return savedPurchase;
    }

    @Override
    public List<PurchaseItem> findPurchaseItemsOfUser(String username) {
        User user=userRepository.findByUsername(username);
        return purchaseRepositroy.findAllPurchasesOfUser(username);
    }

    @Override
    public List<Purchase> findAllPurchases() {
        return purchaseRepositroy.findAll();
    }

    @Override
    public void deletePurchase(Long id) {
        purchaseRepositroy.deleteById(id);
    }
}
