package fr.shahzeb.fund.datamodel;

import java.util.Date;

public class Patient {
    private String patNumHC;
    private String lastName;
    private String firstName;
    private String address;
    private String tel;
    private int insuranceId;
    private Date subscriptionDate;

    // Constructor
//    public Patient(String patNumHC, String lastName, String firstName, String address, String tel, int insuranceId, String subscriptionDate) throws ParseException {
//        this.patNumHC = patNumHC;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.address = address;
//        this.tel = tel;
//        this.insuranceId = insuranceId;
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        this.subscriptionDate = dateFormat.parse(subscriptionDate);
//    }

    public Patient() {

    }


    // Getters
    public String getPatNumHC() {
        return patNumHC;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getTel() {
        return tel;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }
    public void setPatNumHC(String patNumHC) {
        this.patNumHC = patNumHC;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patNumHC='" + patNumHC + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                ", insuranceId=" + insuranceId +
                ", subscriptionDate=" + subscriptionDate +
                '}';
    }
}

