package edu.citytech.counter.dto;

import io.micronaut.serde.annotation.SerdeImport;

@SerdeImport
public class Developer {

    private String name;
    private String[] skills;
    private int yearsOfEcperience = 0;

    public Developer(String name, String[] skills, int yearsOfEcperience) {
        this.name = name;
        this.skills = skills;
        this.yearsOfEcperience = yearsOfEcperience;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getSkills() {
        return skills;
    }
    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public int getYearsOfEcperience() {
        return yearsOfEcperience;
    }

    public void setYearsOfEcperience(int yearsOfEcperience) {
        this.yearsOfEcperience = yearsOfEcperience;
    }
    

}
