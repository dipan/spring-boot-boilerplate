package com.trafficrecorder.trafficrecorder.api.v0.visitor;

import com.sun.xml.internal.ws.api.message.Header;
import com.trafficrecorder.trafficrecorder.api.v0.RestControllerV0;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/visitor")
@RequestMapping(RestControllerV0.BASE_URL + "/visitor")
public class VisitorController extends RestControllerV0 {
    @PostMapping
    public String postVisitorCount() {
        try {
//            authoriseUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Visitor details recorded successfully";
    }
}
