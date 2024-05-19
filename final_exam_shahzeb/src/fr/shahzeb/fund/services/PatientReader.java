package fr.shahzeb.fund.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.shahzeb.fund.datamodel.Patient;


public class PatientReader {
    public PatientReader() {
        try {
            readAll();
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Patient> readAll() throws IOException, ParseException {

        Path currentFilePath = Path.of("resources/patients.csv");
        System.out.println("looking for file at this location:" + currentFilePath.toFile().getAbsolutePath());
        List<String> lines;
        try {
            lines = Files.readAllLines(currentFilePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lines);

        List<Patient> patients = new ArrayList<>();
        lines.remove(0); // Skip the header
        //data mapping
        //pat_num_HC;pat_lastname;pat_firstname;pat_address;pat_tel;pat_insurance_id;pat_subscription_date
        //"1256987452365";Martin;Bernard;Chatillon;"0106060606";2;01/10/2010
        for (String line : lines) {
            String[] parts = line.split(";");
            Patient patient = extractPatient(parts);
            patients.add(patient);
        }

        List<Patient> patientsWithStream = lines.stream()
                .skip(1) // Skip the header
                .map(s -> {
                    try {
                        return extractPatient(s.split(";"));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();

        System.out.println(patientsWithStream);
        return patients;
    }

    private static Patient extractPatient(String[] row) throws ParseException {
        Patient patient = new Patient();
        patient.setPatNumHC(row[0]);
        patient.setLastName(row[1]);
        patient.setFirstName(row[2]);
        patient.setAddress(row[3]);
        patient.setTel(row[4]);
        patient.setInsuranceId(Integer.parseInt(row[5]));
        //LocalDate today = LocalDate.of(2024, 02, 19);
        Date subscriptionDate;
        try {
            subscriptionDate = new SimpleDateFormat("dd/MM/yyyy").parse(row[6]);
            patient.setSubscriptionDate(subscriptionDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return patient;
    }
}

