package fr.shahzeb.fund.services;


import fr.shahzeb.fund.datamodel.Medication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicationDAO extends BaseDAO<Medication> {

    public MedicationDAO(String url) {
        super(url);
    }

    @Override
    protected Medication extractEntity(ResultSet resultSet) throws SQLException {
        Medication medication = new Medication();
        medication.setMedicationCode(resultSet.getInt("medication_code"));
        medication.setMedicationName(resultSet.getString("medication_name"));
        medication.setMedicationComment(resultSet.getString("medication_comment"));
        return medication;
    }

    @Override
    protected void setCreateStatementParams(PreparedStatement preparedStatement, Medication entity) throws SQLException {
        preparedStatement.setInt(1, entity.getMedicationCode());
        preparedStatement.setString(2, entity.getMedicationName());
        preparedStatement.setString(3, entity.getMedicationComment());
    }

    @Override
    protected void setUpdateStatementParams(PreparedStatement preparedStatement, Medication entity) throws SQLException {
        preparedStatement.setString(1, entity.getMedicationName());
        preparedStatement.setString(2, entity.getMedicationComment());
        preparedStatement.setInt(3, entity.getMedicationCode());
    }
}


