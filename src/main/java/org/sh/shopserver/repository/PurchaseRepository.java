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

    @Query("select " + // 가져올 데이터 선택 (필드와 별칭 설정)
            "prd.name as name, pur.quantity as quantity, pur.purchaseTime as purchaseTime " +
            // Purchase(pur)와 Product(prd)를 조인
            "from Purchase pur left join Product prd on prd.id = pur.product.id " +
            // 특정 사용자의 구매 내역만 필터링
            "where pur.user.username = :username")
            // JPQL 쿼리 실행 결과를 PurchaseItem 형태로 반환
                //조건: Purchase 엔티티에서 사용자 이름(pur.user.username)이 입력된 username과 동일한 데이터만 선택.
    List<PurchaseItem> findAllPurchasesOfUser(@Param("username") String username);
    // 메서드의 파라미터 username 값을 쿼리의 :username에 매핑하여 사용
}