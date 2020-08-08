package com.trafficrecorder.trafficrecorder.api;

import org.json.JSONObject;

public enum ResponseStatus {
    SUCCESS {
        @Override
        public Integer statusCode() {
            return 200;
        }
    };

    public JSONObject message() {
        return null;
    }
    public Integer statusCode() {
        return null;
    }
}
