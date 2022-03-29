package com.wavehq.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PayPeriod {
    private String fromDate;
    private String toDate;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = dateFormat.format(fromDate);
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = dateFormat.format(toDate);
    }

}
