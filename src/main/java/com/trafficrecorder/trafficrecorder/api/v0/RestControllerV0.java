package com.trafficrecorder.trafficrecorder.api.v0;

import com.sun.xml.internal.ws.api.message.Header;

public abstract class RestControllerV0 {
    public static final String BASE_URL = "/api/v0";

    public  void authoriseUser(Header header)throws Exception{
        //todo throw error if user is not authorized
    }
}
