package net.proselyte.transactionsDeclarative.utils;

import net.proselyte.transactionsDeclarative.model.Project;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectsMapper implements RowMapper<Project> {
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();

        project.setDevelopersId(rs.getInt("DEVELOPERS_ID"));
        project.setProjectName(rs.getString("NAME"));
        project.setCompanyName(rs.getString("COMPANY"));

        return project;
    }
}
