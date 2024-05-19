package fr.shahzeb.fund.services;

import fr.shahzeb.fund.datamodel.Prescription;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionReader {
    public List<Prescription> readAll(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        List<Prescription> prescriptions = new ArrayList<>();

        lines.remove(0); // Skip the header

        for (String line : lines) {
            String[] parts = line.split(";");
            try {
                Prescription prescription = extractPrescription(parts);
                prescriptions.add(prescription);
            } catch (NumberFormatException e) {
                System.err.println("Error parsing Prescription. Skipping line: " + line);
                // Log or handle the error as needed
            }
        }

        return prescriptions;
    }

    private Prescription extractPrescription(String[] row) throws NumberFormatException {
        int prescId = Integer.parseInt(row[0]);
        String prescRefPat = row[1];
        int prescCode = Integer.parseInt(row[2]);
        int prescDays = Integer.parseInt(row[3]);

        return new Prescription(prescId, prescRefPat, prescCode, prescDays);
    }
}


