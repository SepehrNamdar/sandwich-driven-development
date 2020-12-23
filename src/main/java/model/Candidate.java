package model;

import use_case.AnyRecruiterFoundException;

import java.time.LocalDate;
import java.util.List;

public class Candidate {
    private final List<String> skills;
    private final String name;

    public Candidate(String name, List<String> skills) {
        this.name = name;
        this.skills = skills;
    }

    public Recruiter bookRecruiter(LocalDate availability, List<Recruiter> allRecruiters) {
        Recruiter appropriateRecruiter = allRecruiters.stream()
                .filter(r -> r.getAvailabilities().contains(availability))
                .filter(availableRecruiter -> availableRecruiter.canTest(skills))
                .findFirst()
                .orElseThrow(AnyRecruiterFoundException::new);

        appropriateRecruiter.book(availability);
        return appropriateRecruiter;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "skills=" + skills +
                ", name='" + name + '\'' +
                '}';
    }
}
