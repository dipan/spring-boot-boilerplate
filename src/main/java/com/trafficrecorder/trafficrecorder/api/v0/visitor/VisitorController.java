package com.trafficrecorder.trafficrecorder.api.v0.visitor;

import com.trafficrecorder.trafficrecorder.api.v0.RestControllerV0;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/visitor")
@RequestMapping(RestControllerV0.BASE_URL + "/visitor")
public class VisitorController extends RestControllerV0 {
    @PostMapping
    public String postVisitor() {
        try {
//            authoriseUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Visitor details recorded successfully";
    }

    @GetMapping
    public List<String> getVisitor() {
        List<String> visitorList = new ArrayList<>();
        try {
//            authoriseUser();
            visitorList.add("Visitor 1");
            visitorList.add("Visitor 2");
            visitorList.add("Visitor 3");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return visitorList;
    }
}
