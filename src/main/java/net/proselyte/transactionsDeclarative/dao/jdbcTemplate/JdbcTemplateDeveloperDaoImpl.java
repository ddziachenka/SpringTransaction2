package net.proselyte.transactionsDeclarative.dao.jdbcTemplate;

import net.proselyte.transactionsDeclarative.dao.DeveloperDao;
import net.proselyte.transactionsDeclarative.model.Developer;
import net.proselyte.transactionsDeclarative.model.Project;
import net.proselyte.transactionsDeclarative.utils.DevelopersMapper;
import net.proselyte.transactionsDeclarative.utils.ProjectsMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class JdbcTemplateDeveloperDaoImpl implements DeveloperDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void createDeveloper(String name, String specialty, Integer experience) {


        String SQL = "INSERT INTO DEVELOPERS (NAME, SPECIALTY, EXPERIENCE) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, name, specialty, experience);
        System.out.println("Developer's record created/updated successfully. Name: " +
                name + ", Specilaty: " + specialty + ", Experience: " + experience + "\n");
    }

    @Override
    public List<Developer> listDevelopers() {
        String SQL = "SELECT * FROM DEVELOPERS";
        List<Developer> developers = jdbcTemplate.query(SQL, new DevelopersMapper());

        return developers;
    }

    @Override
    public List<Project> listDevelopersProjects(Integer id) {
        String SQL = "SELECT * FROM PROJECTS WHERE DEVELOPERS_ID = " + id;
        List<Project> projectList = jdbcTemplate.query(SQL, new ProjectsMapper());
        return projectList;
    }
}
