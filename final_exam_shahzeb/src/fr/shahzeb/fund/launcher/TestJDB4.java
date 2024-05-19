package fr.shahzeb.fund.launcher;

import fr.shahzeb.fund.datamodel.*;
import fr.shahzeb.fund.services.InsuranceDAO;
import fr.shahzeb.fund.services.MedicationDAO;
import fr.shahzeb.fund.services.PrescriptionDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class TestJDB4 {

    public static void main(String[] args) {
        // JDBC connection parameters for an in-memory H2 database without username and password
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";

        try {
            // Create instances of DAO classes
            InsuranceDAO insuranceDAO = new InsuranceDAO(url);
            MedicationDAO medicationDAO = new MedicationDAO(url);
            PrescriptionDAO prescriptionDAO = new PrescriptionDAO(url);

            // Read data from CSV or any source
            List<Insurance> insurances = readInsurances(); // Implement the readInsurances method
            List<Medication> medications = readMedications(); // Implement the readMedications method
            List<Prescription> prescriptions = readPrescriptions(); // Implement the readPrescriptions method

            // Create entries in the database
            insuranceDAO.create(insurances, "INSERT INTO INSURANCES (insurance_id, insurance_name) VALUES (?, ?)");
            medicationDAO.create(medications, "INSERT INTO MEDICATIONS (medication_code, medication_name, medication_comment) VALUES (?, ?, ?)");
            prescriptionDAO.create(prescriptions, "INSERT INTO PRESCRIPTIONS (presc_id, presc_ref_pat, presc_code, presc_days) VALUES (?, ?, ?, ?)");

            // Display patient information with associated treatment
            displayPatientTreatmentInfo(url);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void displayPatientTreatmentInfo(String url) throws SQLException {

    }


    private static List<Insurance> readInsurances() {
        return null;
    }

    private static List<Medication> readMedications() {
        return null;
    }

    private static List<Prescription> readPrescriptions() {
        return null;
    }
}

