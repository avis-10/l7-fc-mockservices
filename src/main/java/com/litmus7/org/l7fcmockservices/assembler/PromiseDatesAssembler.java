package com.litmus7.org.l7fcmockservices.assembler;

import com.litmus7.org.l7fcmockservices.domain.Item;
import com.litmus7.org.l7fcmockservices.domain.PromiseDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class PromiseDatesAssembler {

    public static PromiseDate assemblePromiseDates(Item item) {
        PromiseDate promiseDate = new PromiseDate();
        promiseDate.setCarrierServiceCode(item.getCarrierServiceCode());
        promiseDate.setShipNode(item.getShipNode());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000XXX", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("MST"));  // MST - Mountain ST (US & Canada)
        Date date = new Date();
        String today = dateFormat.format(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        promiseDate.setDcTimeZone(today.split("000")[1]);
        promiseDate.setShippingDate(today);

        calendar.add(Calendar.DAY_OF_MONTH, 5);
        promiseDate.setDeliveryDate(dateFormat.format(calendar.getTime()));

        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 5);
        promiseDate.setCutoffTimestamp(dateFormat.format(calendar.getTime()));

        promiseDate.setDeliveryDateType(0);
        promiseDate.setDelayAdded(false);

        return promiseDate;
    }
}
