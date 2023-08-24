package com.litmus7.org.l7fcmockservices.service.impl;

import static com.litmus7.org.l7fcmockservices.assembler.ItemsAssembler.itemsToItemAssemblerWithRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.litmus7.org.l7fcmockservices.assembler.PromiseDatesAssembler;
import com.litmus7.org.l7fcmockservices.assembler.SourcingAssembler;
import com.litmus7.org.l7fcmockservices.domain.Item;
import com.litmus7.org.l7fcmockservices.domain.PromiseDate;
import com.litmus7.org.l7fcmockservices.domain.ResponseItem;
import com.litmus7.org.l7fcmockservices.domain.SourcingAvailability;
import com.litmus7.org.l7fcmockservices.entity.Items;
import com.litmus7.org.l7fcmockservices.entity.Sourcing;
import com.litmus7.org.l7fcmockservices.model.SourcingRequest;
import com.litmus7.org.l7fcmockservices.model.SourcingResponse;
import com.litmus7.org.l7fcmockservices.repository.ItemsRepository;
import com.litmus7.org.l7fcmockservices.repository.PromiseDatesRepository;
import com.litmus7.org.l7fcmockservices.repository.SourcingRepository;
import com.litmus7.org.l7fcmockservices.service.SourcingService;
import com.litmus7.org.l7fcmockservices.util.CommonUtils;

@Service
@Primary
public class SourcingServiceImpl2 implements SourcingService {

    @Autowired
    private ItemsRepository itemsRepo;

    @Autowired
    private SourcingRepository sourcingRepo;

    @Autowired
    private PromiseDatesRepository promiseDatesRepo;

    @Override
    public SourcingResponse generateResponse(SourcingRequest request) {

        Sourcing source = SourcingAssembler.assembleSource(request);
        sourcingRepo.save(source);

        SourcingAvailability sourcingAvailability = calculateAvailability(request.getItems());  // FULL, PARTIAL, NULL
        SourcingResponse response = null;
        List<Item> allItems = new ArrayList<>();
        List<ResponseItem> allRespItems = new ArrayList<>();
        
        if (sourcingAvailability.getItemAvailability().equals("FULL")) {
            response = new SourcingResponse();
            response.setAvailable(true);

            allItems = sourcingAvailability.getItemsInDbWithQty();

            List<PromiseDate> promiseDates = calculatePromiseDates(allItems);
                       
                       
            response.setItems(createResponseItem(allItems));
            response.setPromiseDates(promiseDates);


        } else if (sourcingAvailability.getItemAvailability().equals("NULL")) {
            response = new SourcingResponse();
            response.setAvailable(false);
            allItems = sourcingAvailability.getItemsNotInDb();
            allItems.forEach(item -> {
                item.setMaxShipNodeQuantity(0.0);
                item.setUnavailableReason("NOT_ENOUGH_PRODUCT_CHOICES");
                item.setTotalAvailableQuantity(0.0);
                item.setRequestedQtyAvailable(false);
            });
            response.setItems(createResponseItem(allItems));


        } else if (sourcingAvailability.getItemAvailability().equals("PARTIAL")) {
            response = new SourcingResponse();
            response.setAvailable(false);

            allItems = sourcingAvailability.getItemsInDbWithQty();

            List<PromiseDate> promiseDates = calculatePromiseDates(sourcingAvailability.getItemsInDbWithQty());
            response.setPromiseDates(promiseDates);

            allItems.addAll(sourcingAvailability.getItemsInDbWithoutQty());

            sourcingAvailability.getItemsNotInDb().forEach(item -> {
                item.setMaxShipNodeQuantity(0.0);
                item.setUnavailableReason("NOT_ENOUGH_PRODUCT_CHOICES");
                item.setTotalAvailableQuantity(0.0);
                item.setRequestedQtyAvailable(false);
            });
            allItems.addAll(sourcingAvailability.getItemsNotInDb());
        }

        response.setItems(createResponseItem(allItems));
        response.setDatesCalculated(true);
        return response;
    }

    private List<ResponseItem> createResponseItem(List<Item> allItems) {
    	ResponseItem responseItem = new ResponseItem();
    	List<ResponseItem> allRespItems = new ArrayList<>();
    	for (Item allItem : allItems) {
    		responseItem = (ResponseItem)CommonUtils.copyObject(allItem, responseItem);
        	allRespItems.add(responseItem);
        } 
    	return allRespItems;
    }
    
    private SourcingAvailability calculateAvailability(List<Item> requestItems) {

        SourcingAvailability availability = new SourcingAvailability();
        List<Item> dbItemsWithQty = new ArrayList<>();
        List<Item> dbItemsWithoutQty = new ArrayList<>();
        List<Item> notInDbItems = new ArrayList<>();

        requestItems.
                stream().
                forEach(reqItem -> {
                	if (null == reqItem.getLocationIds()) {
                		reqItem.setLocationIds("0801");
                	}
                    Items itemFromDb = itemsRepo
                            .findItemsByItemIdLocIdFulfillment(reqItem.getItemId(), reqItem.getLocationIds(), reqItem.getFulfillmentType().name());
                    if (Objects.nonNull(itemFromDb)) {
                        if (itemFromDb.getQuantity() >= reqItem.getRequiredQuantity())
                            dbItemsWithQty.add(itemsToItemAssemblerWithRequest(itemFromDb, reqItem));
                        else dbItemsWithoutQty.add(itemsToItemAssemblerWithRequest(itemFromDb, reqItem));
                    } else {
                        notInDbItems.add(reqItem);
                    }
                });
        availability.setItemsInDbWithQty(dbItemsWithQty);
        availability.setItemsInDbWithoutQty(dbItemsWithoutQty);
        availability.setItemsNotInDb(notInDbItems);

        if (dbItemsWithQty.size() == requestItems.size()) {
            availability.setItemAvailability("FULL");
        } else if (dbItemsWithQty.isEmpty() && dbItemsWithoutQty.isEmpty()) {
            availability.setItemAvailability("NULL");
        } else if (!dbItemsWithQty.isEmpty() || !dbItemsWithoutQty.isEmpty()) {
            availability.setItemAvailability("PARTIAL");
        }
        return availability;
    }
    private List<PromiseDate> calculatePromiseDates(List<Item> itemList) {
        List<PromiseDate> datesList = itemList.
                stream().
                map(item -> PromiseDatesAssembler.assemblePromiseDates(item)).
                collect(Collectors.toList());

//            No need to persist promiseDates
//        datesList.forEach(x -> {
//            PromiseDates promiseDates = new PromiseDates();
//            BeanUtils.copyProperties(x, promiseDates);
//            promiseDatesRepo.save(promiseDates);
//        });

        return datesList;
    }
}
