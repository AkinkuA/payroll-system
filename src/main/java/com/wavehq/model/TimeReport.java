package com.wavehq.model;

import javax.persistence.*;

@Entity
@Table(name = "timereport")
public class TimeReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, name="file_name")
    private String fileName;


    public Integer getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
