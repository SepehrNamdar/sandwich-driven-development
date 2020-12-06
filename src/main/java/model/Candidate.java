package model;

import use_case.AnyRecruiterFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Candidate {
    private List<String> skills;
    private String name;

    public Recruiter findAppropriateRecruiter(
            LocalDate availability, List<Recruiter> allRecruiters) {

        return allRecruiters.stream()
                .filter(availableRecruiter -> availableRecruiter.canTest(skills))
                .filter(recruiter -> recruiter.isAvailable(availability))
                .findFirst()
                .orElseThrow(AnyRecruiterFoundException::new);
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
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
