package fr.shahzeb.fund.services;

import fr.shahzeb.fund.datamodel.Patient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientBLService {

    public static Integer computeSeniority(Patient patient) {
        // Assuming current date is used for computing seniority
        long currentTimeMillis = System.currentTimeMillis();
        long subscriptionTimeMillis = patient.getSubscriptionDate().getTime();

        // Calculate the difference in milliseconds
        long differenceMillis = currentTimeMillis - subscriptionTimeMillis;

        // Convert milliseconds to years (approximate calculation)
        long years = differenceMillis / (365 * 24 * 60 * 60 * 1000L);

        return Math.toIntExact(years);
    }

    public static Map<String, Integer> computeSeniorityByPatient(List<Patient> patients) {
        Map<String, Integer> seniorityMap = new HashMap<>();

        for (Patient patient : patients) {
            String patientName = patient.getPatNumHC();
            int seniority = computeSeniority(patient);

            seniorityMap.put(patientName, seniority);
        }

        return seniorityMap;
    }

}

