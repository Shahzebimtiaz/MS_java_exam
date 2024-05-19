package fr.shahzeb.fund.launcher;

import fr.shahzeb.fund.services.PatientDAO;
import fr.shahzeb.fund.datamodel.Patient;
import fr.shahzeb.fund.services.PatientReader;
import fr.shahzeb.fund.services.TestJDBC1;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class TestJDB2 {

    public static void main(String[] args) {
        // JDBC connection parameters for an in-memory H2 database without username and password
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";



        try {
            TestJDBC1.test();
            // Read patients
            PatientReader patientReader = new PatientReader();
            List<Patient> patients = patientReader.readAll();

            // Create a PatientDAO instance
            PatientDAO patientDAO = new PatientDAO(url);

            // Create patients in the database
            patientDAO.create(patients);

            // Search for a specific patient
            List<Patient> searchResult = patientDAO.search("Solti", "Anna");
            System.out.println("Search Result: " + searchResult);

            if (!searchResult.isEmpty()) {
                // Update the first patient in the search result
                Patient patientToUpdate = searchResult.get(0);
                patientToUpdate.setAddress("Paris");
                patientToUpdate.setTel("0104040404");
                patientToUpdate.setInsuranceId(3);
                patientToUpdate.setSubscriptionDate(patientToUpdate.getSubscriptionDate()); // Keep the same subscription date
                patientDAO.update(patientToUpdate);

                // Delete the updated patient
                patientDAO.delete(patientToUpdate.getPatNumHC());
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
