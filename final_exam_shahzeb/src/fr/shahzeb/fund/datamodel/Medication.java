package fr.shahzeb.fund.datamodel;

public class Medication {
    private int medicationCode;
    private String medicationName;
    private String medicationComment;

    public Medication(int medicationCode, String medicationName, String medicationComment) {
        this.medicationCode = medicationCode;
        this.medicationName = medicationName;
        this.medicationComment = medicationComment;
    }

    public Medication() {}

    public int getMedicationCode() {
        return medicationCode;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public String getMedicationComment() {
        return medicationComment;
    }

    public void setMedicationCode(int medicationCode) {
        this.medicationCode = medicationCode;
    }

    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }

    public void setMedicationComment(String medicationComment) {
        this.medicationComment = medicationComment;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "medicationCode=" + medicationCode +
                ", medicationName='" + medicationName + '\'' +
                ", medicationComment='" + medicationComment + '\'' +
                '}';
    }
}


