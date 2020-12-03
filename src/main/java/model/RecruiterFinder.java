package model;

import use_case.AnyRecruiterFoundException;
import use_case.RecruiterRepository;

import java.time.LocalDate;
import java.util.List;

// Domain Service
public class RecruiterFinder {
    public Recruiter findAppropriateRecruiter(
            LocalDate availability, Candidate candidate, List<Recruiter> availableRecruiters, RecruiterRepository recruiters) {
        List<String> candidateSkills = candidate.getSkills();

        Recruiter appropriateRecruiter = availableRecruiters.stream()
                .filter(availableRecruiter -> availableRecruiter.canTest(candidateSkills))
                .findFirst()
                .orElseThrow(AnyRecruiterFoundException::new);

        return recruiters.bookAvailability(appropriateRecruiter, availability);
    }
}
