package model;

import java.time.LocalDate;
import java.util.List;

public class Recruiter {
    private final String recruiterId;
    private final List<String> skills;
    private final List<LocalDate> availabilities;
    private final String name;

    public Recruiter(String recruiterId, String name, List<String> skills, List<LocalDate> availabilities) {
        this.recruiterId = recruiterId;
        this.name = name;
        this.skills = skills;
        this.availabilities = availabilities;
    }

    public boolean canTest(List<String> candidateSkills) {
        return getSkills().containsAll(candidateSkills);
    }

    public void book(LocalDate date) {
        availabilities.remove(date);
    }

    public List<String> getSkills() {
        return skills;
    }

    public List<LocalDate> getAvailabilities() {
        return availabilities;
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
