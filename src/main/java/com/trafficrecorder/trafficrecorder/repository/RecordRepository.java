package com.trafficrecorder.trafficrecorder.repository;

import com.trafficrecorder.trafficrecorder.datamodel.Record;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordRepository extends CrudRepository<Record, Integer> {
    public List<Record> findByWebsite(String website);

    public List<Record> findByDateAndWebsite(String date, String website);

    @Query(value = "SELECT SUM(r.visitor_count) FROM record AS r GROUP BY r.website HAVING r.website = :website", nativeQuery = true)
    public Integer findWebsiteVisitorCount(@Param("website") String website);
}
