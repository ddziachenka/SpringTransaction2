package net.proselyte.transactionsDeclarative;


import net.proselyte.transactionsDeclarative.dao.jdbcTemplate.JdbcTemplateDeveloperDaoImpl;
import net.proselyte.transactionsDeclarative.dao.jdbcTemplate.JdbcTemplateProjectDaoImpl;
import net.proselyte.transactionsDeclarative.model.Developer;
import net.proselyte.transactionsDeclarative.model.Project;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ApplicationRunner {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("transaction-declarative-config.xml");
        JdbcTemplateDeveloperDaoImpl developerDao =
                (JdbcTemplateDeveloperDaoImpl) context.getBean("developerJDBCTemplate");
        JdbcTemplateProjectDaoImpl projectDao =
                (JdbcTemplateProjectDaoImpl) context.getBean("projectJDBCTemplate");

        System.out.println("======== Creating project's records ========");
        projectDao.createProject(90, "ProselyteTutorial", "Proselyte.net");
        projectDao.createProject(90, "SkybleLib", "SkybleSoft");

        System.out.println("======== Creating developer's records ========");
        developerDao.createDeveloper("Proselyte", "Java Developer", 3);
        developerDao.createDeveloper("Mike", "C++ Developer", 5);

        System.out.println("======== List of Developers ========");
        List<Developer> developerList = developerDao.listDevelopers();
        for (Developer developer : developerList) {
            System.out.println(developer);
        }

        System.out.println("======== Proselyte Developer's Projects ========");
        List<Project> projects = developerDao.listDevelopersProjects(90);
        for (Project project : projects) {
            System.out.println(project);
        }

    }
}
