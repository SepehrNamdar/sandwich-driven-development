package application;

import java.util.List;
import java.util.Objects;

public class Recruiter {
    private List<String> skills;

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruiter recruiter = (Recruiter) o;
        return Objects.equals(skills, recruiter.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skills);
    }
}
