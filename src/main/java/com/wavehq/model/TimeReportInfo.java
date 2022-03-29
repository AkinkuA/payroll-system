package com.wavehq.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="time_reports_info", uniqueConstraints = {
        @UniqueConstraint( name = "idx_employee_id_date", columnNames = {"employee_id", "date"})
})
public class TimeReportInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name="employee_id" )
    private Integer employeeId;

    @Column(nullable = false, name="date")
    private Date date;

    @Column(nullable = false, name="hours_worked")
    private Double hoursWorked;

    @Column(nullable = false, name="job_group")
    private String jopGroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date payPeriod) {
        this.date = payPeriod;
    }

    public Double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getJobGroup() {
        return jopGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jopGroup = jobGroup;
    }
}
