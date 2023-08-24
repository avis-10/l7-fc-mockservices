package com.litmus7.org.l7fcmockservices.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {

	public static Object copyObject(Object srcObject, Object destObject) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		destObject = mapper.convertValue(srcObject, destObject.getClass());
		return destObject;
	}
}
