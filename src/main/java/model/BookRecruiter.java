package model;

import java.time.LocalDate;
import java.util.List;

// Domain Service
public class BookRecruiter {
    public Interview planInterview(
            LocalDate availability, Candidate candidate, List<Recruiter> availableRecruiters, RecruiterRepository recruiters) {
        List<String> candidateSkills = candidate.getSkills();
        Recruiter appropriateRecruiter =
                candidate.findAppropriateRecruiter(availableRecruiters, candidateSkills);
        Recruiter recruiter = recruiters.bookAvailability(appropriateRecruiter, availability);// is a shared state ? Yes
        return new Interview().getInterview(availability, candidate, recruiter);
    }
}
