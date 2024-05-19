package fr.shahzeb.fund.services;

import fr.shahzeb.fund.datamodel.Insurance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InsuranceReader {
    public InsuranceReader() {
        try {
            readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Insurance> readAll() throws IOException {
        String filePath = "resources/insurances.csv";
        System.out.println("Looking for file at this location: " + filePath);

        List<Insurance> insurances = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skip the header
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                Insurance insurance = extractInsurance(data);
                insurances.add(insurance);
            }
        }

        List<Insurance> insurancesWithStream = Files.lines(Paths.get(filePath))
                .skip(1) // Skip the header
                .map(s -> extractInsurance(s.split(";")))
                .toList();

        System.out.println(insurancesWithStream);
        return insurances;
    }

    private static Insurance extractInsurance(String[] row) {
        return new Insurance(Integer.parseInt(row[0]), row[1]);
    }
}


