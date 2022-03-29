package com.wavehq.model;

public class EmployeeReport {

    private String employeeId;
    private PayPeriod payPeriod;
    private String amountPaid;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public PayPeriod getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(PayPeriod payPeriod) {
        this.payPeriod = payPeriod;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {

        this.amountPaid = "$" + String.format("%.2f", amountPaid);
    }

    public static boolean checkEmployeeAndPayPeriod(EmployeeReport employeeReport1, EmployeeReport employeeReport2){
        return employeeReport1.getEmployeeId().equals(employeeReport2.getEmployeeId()) &&
                employeeReport1.getPayPeriod().getFromDate().equals(employeeReport2.getPayPeriod().getFromDate());
    }
}
