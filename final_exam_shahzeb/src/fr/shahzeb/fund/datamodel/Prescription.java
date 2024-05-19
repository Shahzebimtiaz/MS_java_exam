package fr.shahzeb.fund.datamodel;

public class Prescription {
    private int prescId;
    private String prescRefPat;
    private int prescCode;
    private int prescDays;

    public Prescription(int prescId, String prescRefPat, int prescCode, int prescDays) {
        this.prescId = prescId;
        this.prescRefPat = prescRefPat;
        this.prescCode = prescCode;
        this.prescDays = prescDays;
    }

    public Prescription() {

    }

    public int getPrescId() {
        return prescId;
    }

    public String getPrescRefPat() {
        return prescRefPat;
    }

    public int getPrescCode() {
        return prescCode;
    }

    public int getPrescDays() {
        return prescDays;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                "prescId=" + prescId +
                ", prescRefPat='" + prescRefPat + '\'' +
                ", prescCode=" + prescCode +
                ", prescDays=" + prescDays +
                '}';
    }

    public void setPrescId(int prescId) {
        this.prescId = prescId;
    }

    public void setPrescRefPat(String prescRefPat) {
        this.prescRefPat = prescRefPat;
    }

    public void setPrescCode(int prescCode) {
        this.prescCode = prescCode;
    }

    public void setPrescDays(int prescDays) {
        this.prescDays = prescDays;
    }
}

