package net.proselyte.transactionsDeclarative.dao;


import net.proselyte.transactionsDeclarative.model.Developer;
import net.proselyte.transactionsDeclarative.model.Project;

import javax.sql.DataSource;
import java.util.List;

public interface DeveloperDao {
    public void setDataSource(DataSource dataSource);

    public void createDeveloper(String name, String specialty, Integer experience);

    public List<Developer> listDevelopers();

    public List<Project> listDevelopersProjects(Integer id);
}
