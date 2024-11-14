package org.sh.shopserver.repository.projection;

import java.time.LocalDateTime;

public interface PurchaseItem {
    String getName();
    String getQuantity();
    LocalDateTime getPurchaseTime();
}
