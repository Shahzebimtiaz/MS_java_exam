package fr.shahzeb.fund.services;


import fr.shahzeb.fund.datamodel.Insurance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsuranceDAO extends BaseDAO<Insurance> {

    public InsuranceDAO(String url) {
        super(url);
    }

    @Override
    protected Insurance extractEntity(ResultSet resultSet) throws SQLException {
        Insurance insurance = new Insurance();
        insurance.setInsuranceId(resultSet.getInt("insurance_id"));
        insurance.setInsuranceName(resultSet.getString("insurance_name"));
        return insurance;
    }

    @Override
    protected void setCreateStatementParams(PreparedStatement preparedStatement, Insurance entity) throws SQLException {
        preparedStatement.setInt(1, entity.getInsuranceId());
        preparedStatement.setString(2, entity.getInsuranceName());
    }

    @Override
    protected void setUpdateStatementParams(PreparedStatement preparedStatement, Insurance entity) throws SQLException {
        preparedStatement.setString(1, entity.getInsuranceName());
        preparedStatement.setInt(2, entity.getInsuranceId());
    }
}


