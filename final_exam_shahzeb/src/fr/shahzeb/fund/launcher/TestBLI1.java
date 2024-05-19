package fr.shahzeb.fund.launcher;

import fr.shahzeb.fund.services.PatientBLService;
import fr.shahzeb.fund.services.PatientReader;
import fr.shahzeb.fund.datamodel.Patient;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class TestBLI1 {
    public static void main(String[] args) {
        try {
            // Read patients using PatientReader
            PatientReader patientReader = new PatientReader();
            List<Patient> patients = patientReader.readAll();

            // Display patients
            System.out.println("Patients:");
            for (Patient patient : patients) {
                System.out.println(patient);
            }

            // Get the 6th patient (reading order)
            Patient sixthPatient = patients.get(5);

            // Compute and display seniority
            Integer seniority = PatientBLService.computeSeniority(sixthPatient);
            System.out.println("\nSeniority of the 6th patient: " + seniority + " years");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}

