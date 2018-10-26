package net.proselyte.transactionsDeclarative.dao;

import javax.sql.DataSource;

public interface ProjectDao {
    public void setDataSource(DataSource dataSource);

    public void createProject(Integer developersId, String projectName, String companyName);
}
