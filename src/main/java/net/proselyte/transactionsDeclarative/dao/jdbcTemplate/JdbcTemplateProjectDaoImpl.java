package net.proselyte.transactionsDeclarative.dao.jdbcTemplate;

import net.proselyte.transactionsDeclarative.dao.ProjectDao;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTemplateProjectDaoImpl implements ProjectDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createProject(Integer developerId, String projectName, String companyName) {
        String SQL = "INSERT INTO PROJECTS (DEVELOPERS_ID, NAME, COMPANY) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, developerId, projectName, companyName);
        System.out.println("Project record created successfully. Project name: " +
                projectName + ", Company: " + companyName + "\n");
    }
}
