package fr.shahzeb.fund.services;

import fr.shahzeb.fund.datamodel.Prescription;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrescriptionDAO extends BaseDAO<Prescription> {

    public PrescriptionDAO(String url) {
        super(url);
    }

    @Override
    protected Prescription extractEntity(ResultSet resultSet) throws SQLException {
        Prescription prescription = new Prescription();
        prescription.setPrescId(resultSet.getInt("presc_id"));
        prescription.setPrescRefPat(resultSet.getString("presc_ref_pat"));
        prescription.setPrescCode(resultSet.getInt("presc_code"));
        prescription.setPrescDays(resultSet.getInt("presc_days"));
        return prescription;
    }

    @Override
    protected void setCreateStatementParams(PreparedStatement preparedStatement, Prescription entity) throws SQLException {
        preparedStatement.setInt(1, entity.getPrescId());
        preparedStatement.setString(2, entity.getPrescRefPat());
        preparedStatement.setInt(3, entity.getPrescCode());
        preparedStatement.setInt(4, entity.getPrescDays());
    }

    @Override
    protected void setUpdateStatementParams(PreparedStatement preparedStatement, Prescription entity) throws SQLException {
        preparedStatement.setInt(1, entity.getPrescCode());
        preparedStatement.setInt(2, entity.getPrescDays());
        preparedStatement.setInt(3, entity.getPrescId());
    }
}

