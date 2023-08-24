/*package com.litmus7.org.l7fcmockservices.service.impl;

import com.litmus7.org.l7fcmockservices.assembler.ItemsAssembler;
import com.litmus7.org.l7fcmockservices.assembler.PromiseDatesAssembler;
import com.litmus7.org.l7fcmockservices.assembler.SourcingAssembler;
import com.litmus7.org.l7fcmockservices.domain.Item;
import com.litmus7.org.l7fcmockservices.domain.PromiseDate;
import com.litmus7.org.l7fcmockservices.entity.Items;
import com.litmus7.org.l7fcmockservices.entity.PromiseDates;
import com.litmus7.org.l7fcmockservices.entity.Sourcing;
import com.litmus7.org.l7fcmockservices.model.SourcingRequest;
import com.litmus7.org.l7fcmockservices.model.SourcingResponse;
import com.litmus7.org.l7fcmockservices.repository.ItemsRepository;
import com.litmus7.org.l7fcmockservices.repository.PromiseDatesRepository;
import com.litmus7.org.l7fcmockservices.repository.SourcingRepository;
import com.litmus7.org.l7fcmockservices.service.SourcingService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class SourcingServiceImpl implements SourcingService {

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

        Map<List<Items>, String> availabilityMap = calculateAvailability(request);  // FULL, PARTIAL, NULL
        SourcingResponse response = null;
        List<Item> allItems = new ArrayList<>();
        if (availabilityMap.containsValue("FULL")) {
            response = new SourcingResponse();
            response.setAvailable(true);
            allItems = ItemsAssembler.itemsToItemAssembler(availabilityMap.keySet().stream().findFirst().get());

            allItems.forEach(item -> item.setRequestedQtyAvailable(true));
            List<PromiseDate> promiseDates = calculatePromiseDates(request.getItems());
            response.setPromiseDates(promiseDates);


        } else if (availabilityMap.containsValue("NULL")) {
            response = new SourcingResponse();
            response.setAvailable(false);
            allItems = request.getItems();
            allItems.forEach(item -> {
                item.setMaxShipNodeQuantity(0.0);
                item.setUnavailableReason("NOT_ENOUGH_PRODUCT_CHOICES");
                item.setTotalAvailableQuantity(0.0);
                item.setRequestedQtyAvailable(false);
            });

        } else if (availabilityMap.containsValue("PARTIAL")) {
            response = new SourcingResponse();
            response.setAvailable(true);
            allItems.forEach(item -> item.setRequestedQtyAvailable(false));
            allItems = ItemsAssembler.itemsToItemAssembler(availabilityMap.keySet().stream().findFirst().get());
//            allItems.addAll(request.);

            List<PromiseDate> promiseDates = calculatePromiseDates(request.getItems());
            response.setPromiseDates(promiseDates);
        }

        response.setItems(allItems);
        response.setDatesCalculated(true);
        return response;
    }

    private Map<List<Items>, String> calculateAvailability(SourcingRequest request) {

        Map<List<Items>, String> itemsMap = new HashMap<>();
        List<Item> requestItems = request.getItems();
        List<Items> outputItems = new ArrayList<>();

        requestItems.
                stream().
                forEach(item -> {
                    Items itemFromDb = itemsRepo
                            .findItemsByItemIdLocIdFulfillment(item.getItemId(), item.getLocationIds(), item.getFulfillmentType().name());
                    if (Objects.nonNull(itemFromDb)) {
                        outputItems.add(itemFromDb);
                    }
                });
        if (outputItems.size() == requestItems.size()) {
            itemsMap.put(outputItems, "FULL");
        } else if (outputItems.isEmpty()) {
            itemsMap.put(outputItems, "NULL");
        } else if (outputItems.size() < requestItems.size() && !outputItems.isEmpty()) {
            itemsMap.put(outputItems, "PARTIAL");
        }

//        Logic to get items in DB and not in DB
//        List<Item> notInDd = requestItems;
//        notInDd.removeAll(outputItems);
//        requestItems.removeAll(notInDd);
        return itemsMap;
    }
    private List<PromiseDate> calculatePromiseDates(List<Item> itemList) {
        List<PromiseDate> datesList = new ArrayList<>();
        datesList = itemList.
                stream().
                map(item -> PromiseDatesAssembler.assemblePromiseDates(item)).
                collect(Collectors.toList());

        List<PromiseDates> entDates = new ArrayList<>();
        datesList.forEach(x -> {
            PromiseDates promiseDates = new PromiseDates();
            BeanUtils.copyProperties(x, promiseDates);
//            No need to persist promiseDates
//            promiseDatesRepo.save(promiseDates);
        });

        return datesList;
    }
}
*/