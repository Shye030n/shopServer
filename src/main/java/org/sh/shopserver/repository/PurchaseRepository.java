package org.sh.shopserver.repository;

import org.sh.shopserver.model.Purchase;
import org.sh.shopserver.repository.projection.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    //  => PurchaseEntity와 DB를 연결하는 Repository(저장소)
    //      <관리할 entity, PK 타입>

    @Query("select " +
    // 쿼리 결과로 가져올 데이터 필드 선택
            "prd.name as name, pur.quantity as quantity, pur.purchaseTime as purchaseTime " +
            // Purchase(pur)와 Product(prd)를 조인해서 데이터를 가져옴
            "from Purchase pur left join Product prd on prd.id = pur.product.id " +
            // 조건: 특정 사용자의 username에 해당하는 구매 내역만 가져옴
            "where pur.user.username = :username")
            // 위의 JPQL 쿼리 실행 결과를 PurchaseItem 형태로 반환하는 메서드 정의
    List<PurchaseItem> findAllPurchasesOfUser(@Param("username") String username);
    // 메서드의 파라미터 username 값을 쿼리의 :username에 매핑
}