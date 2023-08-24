package com.litmus7.org.l7fcmockservices.assembler;

import com.litmus7.org.l7fcmockservices.domain.Item;
import com.litmus7.org.l7fcmockservices.domain.enums.FulfillmentType;
import com.litmus7.org.l7fcmockservices.entity.Items;

import java.util.ArrayList;
import java.util.List;

public class ItemsAssembler {

    public static Items assembleItems(Item item) {
        Items itemsEntity = new Items();
        itemsEntity.setUom(item.getUom());
        itemsEntity.setItemId(item.getItemId());
//        itemsEntity.setQuantity();
        itemsEntity.setLocationIds(item.getLocationIds());
        itemsEntity.setFulfillmentType(item.getFulfillmentType().name());
        itemsEntity.setCarrierServiceCode(item.getCarrierServiceCode());
        itemsEntity.setShipNode(item.getShipNode());
        if(item.getTotalAvailableQuantity() <= 0) {
            itemsEntity.setUnavailableReason("NOT_ENOUGH_PRODUCT_CHOICES");
        }
        return itemsEntity;
    }

    public static List<Item> itemsToItemAssembler(List<Items> items) {
        List<Item> itemList = new ArrayList<>();
        items.stream().forEach(item1 -> {
            Item item = new Item();
            item.setItemId(item1.getItemId());
            item.setUom(item1.getUom());
//            item.setRequiredQuantity(item1.);
            item.setLocationIds(item1.getLocationIds());
            item.setFulfillmentType(FulfillmentType.valueOf(item1.getFulfillmentType()));
            item.setCarrierServiceCode(item1.getCarrierServiceCode());
            item.setShipNode(item1.getShipNode());
//            item.setRequestedQuantity(item1);
//            item.setRequestedQtyAvailable(item1);
//            item.setUnavailableReason(item1);
            item.setMaxShipNodeQuantity(item1.getQuantity());
            item.setTotalAvailableQuantity(item1.getQuantity());

            itemList.add(item);
        });
        return itemList;
    }

    public static Item itemsToItemAssemblerWithRequest(Items item, Item requestItem) {
        Item it = new Item();
        it.setItemId(item.getItemId());
        it.setUom(item.getUom());
        it.setRequiredQuantity(requestItem.getRequiredQuantity());
        it.setRequestedQuantity(requestItem.getRequiredQuantity());
        it.setLocationIds(item.getLocationIds());
        it.setLineId(requestItem.getLineId());
        it.setFulfillmentType(FulfillmentType.valueOf(item.getFulfillmentType()));
        it.setCarrierServiceCode(item.getCarrierServiceCode());
        it.setShipNode(item.getShipNode());
        if (item.getQuantity() >= requestItem.getRequiredQuantity() && item.getQuantity() > 0) {
            it.setRequestedQtyAvailable(true);
            it.setUnavailableReason(null);
        }
        else {
            it.setRequestedQtyAvailable(false);
            it.setUnavailableReason("NOT_ENOUGH_PRODUCT_CHOICES");
        }
        it.setRequestedQuantity(requestItem.getRequiredQuantity());
        it.setMaxShipNodeQuantity(item.getQuantity());
        it.setTotalAvailableQuantity(item.getQuantity());

        return it;
    }
}
