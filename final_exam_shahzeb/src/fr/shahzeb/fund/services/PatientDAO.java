package fr.shahzeb.fund.services;


import fr.shahzeb.fund.datamodel.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    private final String url;

    public PatientDAO(String url) {
        this.url = url;
    }

    public void create(List<Patient> patients) {
        try (Connection connection = DriverManager.getConnection(url)) {
            for (Patient patient : patients) {
                String insertSQL = "INSERT INTO PATIENTS (pat_num_HC, pat_lastname, pat_firstname, pat_address, pat_tel, pat_insurance_id, pat_subscription_date) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                ;;;;;;
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                    preparedStatement.setString(1, patient.getPatNumHC());
                    preparedStatement.setString(2, patient.getLastName());
                    preparedStatement.setString(3, patient.getFirstName());
                    preparedStatement.setString(4, patient.getAddress());
                    preparedStatement.setString(5, patient.getTel());
                    preparedStatement.setInt(6, patient.getInsuranceId());
                    preparedStatement.setDate(7, new java.sql.Date(patient.getSubscriptionDate().getTime()));

                    preparedStatement.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Patient> search(String firstName, String lastName) {
        List<Patient> result = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url)) {
            String searchSQL = "SELECT * FROM PATIENTS WHERE pat_lastname = ? AND pat_firstname = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(searchSQL)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Patient patient = extractPatient(resultSet);
                        result.add(patient);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void update(Patient patient) {
        try (Connection connection = DriverManager.getConnection(url)) {
            String updateSQL = "UPDATE PATIENTS SET pat_address = ?, pat_tel = ?, pat_insurance_id = ?, pat_subscription_date = ? " +
                    "WHERE pat_num_HC = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {
                preparedStatement.setString(1, patient.getAddress());
                preparedStatement.setString(2, patient.getTel());
                preparedStatement.setInt(3, patient.getInsuranceId());
                preparedStatement.setDate(4, new java.sql.Date(patient.getSubscriptionDate().getTime()));
                preparedStatement.setString(5, patient.getPatNumHC());

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String patNumHC) {
        try (Connection connection = DriverManager.getConnection(url)) {
            String deleteSQL = "DELETE FROM PATIENTS WHERE pat_num_HC = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
                preparedStatement.setString(1, patNumHC);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Patient extractPatient(ResultSet resultSet) throws SQLException {
        Patient patient = new Patient();
        patient.setPatNumHC(resultSet.getString("pat_num_HC"));
        patient.setLastName(resultSet.getString("pat_lastname"));
        patient.setFirstName(resultSet.getString("pat_firstname"));
        patient.setAddress(resultSet.getString("pat_address"));
        patient.setTel(resultSet.getString("pat_tel"));
        patient.setInsuranceId(resultSet.getInt("pat_insurance_id"));
        patient.setSubscriptionDate(resultSet.getDate("pat_subscription_date"));

        return patient;
    }
}

