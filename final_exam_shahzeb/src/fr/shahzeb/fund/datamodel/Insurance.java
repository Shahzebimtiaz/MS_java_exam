package fr.shahzeb.fund.datamodel;

public class Insurance {
    private int insuranceId;
    private String insuranceName;

    // Constructor
    public Insurance(int insuranceId, String insuranceName) {
        this.insuranceId = insuranceId;
        this.insuranceName = insuranceName;
    }

    public Insurance() {

    }
//
//    public Insurance(int i, String s) {
//    }

    // Getters
    public int getInsuranceId() {
        return insuranceId;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    // Setters
    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "insuranceId=" + insuranceId +
                ", insuranceName='" + insuranceName + '\'' +
                '}';
    }
}
