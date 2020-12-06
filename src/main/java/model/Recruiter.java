package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Recruiter {
    private final String recruiterId;
    private final List<String> skills;
    private final List<LocalDate> availabilities;
    private final String name;

    public Recruiter(
            String recruiterId, List<String> skills, List<LocalDate> availabilities, String name) {
        this.recruiterId = recruiterId;
        this.skills = skills;
        this.availabilities = availabilities;
        this.name = name;
    }

    boolean canTest(List<String> candidateSkills) {
        return this.skills.containsAll(candidateSkills);
    }

    public boolean isAvailable(LocalDate availability) {
        return availabilities.contains(availability);
    }

    public void book(LocalDate availability) {
        availabilities.remove(availability);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recruiter recruiter = (Recruiter) o;
        return Objects.equals(recruiterId, recruiter.recruiterId) &&
                Objects.equals(skills, recruiter.skills) &&
                Objects.equals(availabilities, recruiter.availabilities) &&
                Objects.equals(name, recruiter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recruiterId, skills, availabilities, name);
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                "recruiterId='" + recruiterId + '\'' +
                ", skills=" + skills +
                ", availabilities=" + availabilities +
                ", name='" + name + '\'' +
                '}';
    }
}
