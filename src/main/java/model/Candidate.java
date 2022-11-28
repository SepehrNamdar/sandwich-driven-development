package model;

import java.util.List;
import java.util.Objects;

// Anemic
public class Candidate {
    private List<String> skills;
    private String name;

    // Sans comportement

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
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
        Candidate candidate = (Candidate) o;
        return Objects.equals(skills, candidate.skills) &&
                Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skills, name);
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "skills=" + skills +
                ", name='" + name + '\'' +
                '}';
    }
}
