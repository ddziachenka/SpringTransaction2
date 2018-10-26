package net.proselyte.transactionsDeclarative.model;

import java.util.List;

public class Developer {
    private Integer id;
    private String name;
    private String specialty;
    private List<Project> projects;
    private Integer experience;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Developer:\n" +
                "id: " + id +
                "\nName: " + name +
                "\nSpecialty: " + specialty +
                "\nExperience: " + experience + "\n";
    }
}
