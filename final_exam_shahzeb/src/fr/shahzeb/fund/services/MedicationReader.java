package fr.shahzeb.fund.services;

import fr.shahzeb.fund.datamodel.Medication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MedicationReader {
    public List<Medication> readAll(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        List<Medication> medications = new ArrayList<>();

        lines.remove(0); // Skip the header

        for (String line : lines) {
            String[] parts = line.split(";");
            Medication medication = extractMedication(parts);
            medications.add(medication);
        }

        return medications;
    }

    private Medication extractMedication(String[] row) {
        return new Medication(Integer.parseInt(row[0]), row[1], row[2]);
    }
}

