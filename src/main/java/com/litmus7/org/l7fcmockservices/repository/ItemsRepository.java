package com.litmus7.org.l7fcmockservices.repository;

import com.litmus7.org.l7fcmockservices.domain.enums.FulfillmentType;
import com.litmus7.org.l7fcmockservices.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {

    // native query
//    @Query(value = "SELECT * FROM items i WHERE i.item_id = ?1 AND i.location_ids = ?2 AND i.fulfillment_type = ?3", nativeQuery = true)

    // JPQL query
    @Query("SELECT i FROM Items i WHERE i.itemId = ?1 AND i.locationIds = ?2 AND i.fulfillmentType = ?3")
    Items findItemsByItemIdLocIdFulfillment(
           String itemId,
           String locationId,
           String fulfillmentType);

}
