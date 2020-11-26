package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Recruiter {
    private List<String> skills;
    private List<LocalDate> availabilities;
    private String name;

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public List<LocalDate> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<LocalDate> availabilities) {
        this.availabilities = availabilities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruiter recruiter = (Recruiter) o;
        return Objects.equals(skills, recruiter.skills) &&
                Objects.equals(availabilities, recruiter.availabilities) &&
                Objects.equals(name, recruiter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skills, availabilities, name);
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                "skills=" + skills +
                ", availabilities=" + availabilities +
                ", name='" + name + '\'' +
                '}';
    }
}
