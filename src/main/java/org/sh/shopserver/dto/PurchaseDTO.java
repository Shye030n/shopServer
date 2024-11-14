package org.sh.shopserver.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sh.shopserver.model.Product;
import org.sh.shopserver.model.User;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseDTO {
    private Long id;
    private String username;
    private Long productId;
    private Integer quantity;
    private LocalDateTime purchaseTime;
}
