package fr.shahzeb.fund.launcher;

import fr.shahzeb.fund.services.PatientBLService;
import fr.shahzeb.fund.datamodel.Patient;
import fr.shahzeb.fund.services.PatientReader;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public class TestBLI2 {
    public static void main(String[] args) {
        try {
            // Read patients using PatientReader
            PatientReader patientReader = new PatientReader();
            List<Patient> patients = patientReader.readAll();

            // Use the computeSeniorityByPatient() method
            Map<String, Integer> seniorityMap = PatientBLService.computeSeniorityByPatient(patients);

            // Display the data structure in the console
            System.out.println("Seniority by Patient:");
            seniorityMap.forEach((patientName, seniority) ->
                    System.out.println(patientName + " = " + seniority + " years"));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
