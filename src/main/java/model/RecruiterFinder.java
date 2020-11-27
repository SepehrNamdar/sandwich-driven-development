package model;

import use_case.AnyRecruiterFoundException;

import java.time.LocalDate;
import java.util.List;

// Domain Service
public class RecruiterFinder {
    public Recruiter findAppropriateRecruiter(
            LocalDate availability, Candidate candidate, List<Recruiter> allRecruiters) {
        List<String> candidateSkills = candidate.getSkills();

        Recruiter appropriateRecruiter = allRecruiters.stream()
                .filter(availableRecruiter -> availableRecruiter.canTest(candidateSkills))
                .filter(recruiter -> recruiter.isAvailable(availability))
                .findFirst()
                .orElseThrow(AnyRecruiterFoundException::new);

        return appropriateRecruiter.book(availability);
    }
}
