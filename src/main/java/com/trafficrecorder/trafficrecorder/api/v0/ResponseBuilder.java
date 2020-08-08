package com.trafficrecorder.trafficrecorder.api.v0;

import com.trafficrecorder.trafficrecorder.api.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {
    public static Map<String, Object> buildSuccessResponse(Object data, ResponseStatus responseStatus) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        return response;
    }
}
