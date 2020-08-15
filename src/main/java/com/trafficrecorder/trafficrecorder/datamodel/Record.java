package com.trafficrecorder.trafficrecorder.datamodel;

import com.trafficrecorder.trafficrecorder.utility.Utility;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints=
        @UniqueConstraint(columnNames={"website", "date"})
)
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String date;
    @Column(nullable = false)
    private Integer visitorCount;
    @Column(nullable = false)
    private String website;

    public Record() {
        setDate(null);
        setVisitorCount(null);
    }


    public Record(String website, String date, Integer visitorCount) {
        this.website = website;
        setDate(date);
        setVisitorCount(visitorCount);
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", website='" + website + '\'' +
                ", date='" + date + '\'' +
                ", visitorCount=" + visitorCount +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
        if (Utility.isStringEmptyOrNull(this.date)) {
            this.date = Utility.getFormattedDate(Utility.DATE_FORMAT);
        }
    }

    public Integer getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount(Integer visitorCount) {
        this.visitorCount = visitorCount;
        if (visitorCount == null) {
            this.visitorCount = 0;
        }
    }
}
