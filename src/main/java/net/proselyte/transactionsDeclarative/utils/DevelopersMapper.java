package net.proselyte.transactionsDeclarative.utils;

import net.proselyte.transactionsDeclarative.model.Developer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DevelopersMapper implements RowMapper<Developer> {
    @Override
    public Developer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Developer developer = new Developer();

        developer.setId(rs.getInt("id"));
        developer.setName(rs.getString("name"));
        developer.setSpecialty(rs.getString("specialty"));
        developer.setExperience(rs.getInt("experience"));

        return developer;
    }
}
