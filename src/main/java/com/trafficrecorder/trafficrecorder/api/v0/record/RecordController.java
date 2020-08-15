package com.trafficrecorder.trafficrecorder.api.v0.record;

import com.sun.xml.internal.ws.api.message.Header;
import com.trafficrecorder.trafficrecorder.api.v0.ResponseBuilder;
import com.trafficrecorder.trafficrecorder.api.v0.RestControllerV0;
import com.trafficrecorder.trafficrecorder.datamodel.Record;
import com.trafficrecorder.trafficrecorder.service.RecordService;
import com.trafficrecorder.trafficrecorder.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RestController("record")
@RequestMapping(RestControllerV0.BASE_URL + "/record")
public class RecordController extends RestControllerV0 {
    @Autowired
    RecordService recordService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public String postRecord(@RequestBody Record record) {
        Integer recordId = null;
        try {
//            authoriseUser();
            recordId = recordService.save(record);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Visitor count recorded successfully. RecordID: " + recordId;
    }

    @GetMapping
    public Map<String, Object> getRecord(
            @Param(value = "date") String date,
            @Param(value = "website") String website
    ) {
        List<Record> recordList = null;
        try {
//            authoriseUser();
            if (Utility.isStringNonEmpty(website)) {
                recordList = recordService.getByWebsite(website);
            } else {
                recordList = recordService.getAll();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseBuilder.buildSuccessResponse(recordList, null);
    }

    @GetMapping(value = "/reactive")
    public Flux<Record> getRecordReactive(
            @Param(value = "date") String date,
            @Param(value = "website") String website
    ) {
        List<Record> recordList = null;
        try {
//            authoriseUser();
            if (Utility.isStringNonEmpty(website)) {
                recordList = recordService.getByWebsite(website);
            } else {
                recordList = recordService.getAll();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return recordService.getAllReactive();
    }

    @GetMapping(value = "/visitorCount")
    public Map<String, Object> getRecordById(
            @Param(value = "website") String website
    ) {
        try {
//            authoriseUser();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseBuilder.buildSuccessResponse(recordService.getVisitorCount(website), null);
//        return recordService.getVisitorCount(website);
    }


    @Override
    public void authoriseUser(Header header) throws Exception {
        //we can do specialized authorization, for example: User is Admin or Super Admin
    }
}
