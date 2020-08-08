package com.trafficrecorder.trafficrecorder.api.v0.visitorcount;

import com.sun.xml.internal.ws.api.message.Header;
import com.trafficrecorder.trafficrecorder.api.v0.ResponseBuilder;
import com.trafficrecorder.trafficrecorder.api.v0.RestControllerV0;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("visitorCount")
@RequestMapping(RestControllerV0.BASE_URL + "/visitorCount")
public class VisitorCountController extends RestControllerV0 {
    @PostMapping
    public String postVisitorCount() {
        try {
//            authoriseUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Visitor count recorded successfully";
    }

    @GetMapping
    public Map<String, Object> getVisitorCount() {
        try {
//            authoriseUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //todo logic to get records for visitors of website
        Map<String, Object> response = new HashMap<>();
        response.put("count", 3);
        return ResponseBuilder.buildSuccessResponse(response, null);
    }


    @Override
    public void authoriseUser(Header header) throws Exception {
        //we can do specialized authorization, for example: User is Admin or Super Admin
    }
}
