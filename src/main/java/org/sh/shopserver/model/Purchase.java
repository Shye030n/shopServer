package org.sh.shopserver.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "purchase")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", referencedColumnName = "id", updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 전송 방식 선택
    @JoinColumn(name="product_id", referencedColumnName = "id",  updatable = false)
        // insertable = false 입력시 이 열은 제외, updatable = false 업데이트시 이 열은 제외
        // => 외래키(Product와 User) 부분을 입력하거나 업데이트할 때 미포함 시킴.
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "purchase_time", nullable = false)
    private LocalDateTime purchaseTime;
}
