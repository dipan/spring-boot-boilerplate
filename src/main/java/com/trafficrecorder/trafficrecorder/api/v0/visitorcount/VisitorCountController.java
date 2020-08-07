package com.trafficrecorder.trafficrecorder.api.v0.visitorcount;

import com.sun.xml.internal.ws.api.message.Header;
import com.trafficrecorder.trafficrecorder.api.v0.RestControllerV0;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Integer getVisitorCount() {
        try {
//            authoriseUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //todo logic to get records for visitors of website
        return new Integer(1);
    }


    @Override
    public void authoriseUser(Header header) throws Exception {
        //we can do specialized authorization, for example: User is Admin or Super Admin
    }
}
