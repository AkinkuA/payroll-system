package com.wavehq.model;

public enum JobGroup {
    A("A", 20.0),
    B("B", 30.0);

    private final String group;
    private final Double pay;

    JobGroup(String group, Double pay){
        this.group = group;
        this.pay = pay;
    }

    public String getGroup() {
        return group;
    }

    public Double getPay() {
        return pay;
    }
}
