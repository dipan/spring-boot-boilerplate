package com.trafficrecorder.trafficrecorder.service;

import com.trafficrecorder.trafficrecorder.datamodel.Record;
import com.trafficrecorder.trafficrecorder.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService {
    @Autowired
    RecordRepository recordRepository;

    public Integer save(Record record) {
        recordRepository.save(record);
        return record.getId();
    }

    public List<Record> getAll() {
        List<Record> recordList = new ArrayList<>();
        recordRepository.findAll().forEach(recordList::add);
        return recordList;
    }

    public Flux<Record> getAllReactive() {
        List<Record> recordList = new ArrayList<>();
        recordRepository.findAll().forEach(recordList::add);
        return Flux.defer(() -> Flux.fromIterable(recordRepository.findAll()));
    }

    public List<Record> getByWebsite(String website) {
        return recordRepository.findByWebsite(website);
    }

    public Integer getVisitorCount(String website) {
        return recordRepository.findWebsiteVisitorCount(website);
    }

    public Record getById(Integer id) {
        return recordRepository.findById(id).get();
    }
}
