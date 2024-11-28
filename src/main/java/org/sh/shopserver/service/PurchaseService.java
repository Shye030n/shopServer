package org.sh.shopserver.service;

import org.sh.shopserver.dto.PurchaseDTO;
import org.sh.shopserver.model.Purchase;
import org.sh.shopserver.repository.projection.PurchaseItem;

import java.util.List;

public interface PurchaseService {
    Purchase savePurchase(PurchaseDTO purchaseDTO);
    List<PurchaseItem> findPurchaseItemsOfUser(String username);
    List<Purchase> findAllPurchases();
    void deletePurchase(Long id);
}
