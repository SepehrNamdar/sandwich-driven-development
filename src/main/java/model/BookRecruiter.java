package model;

import java.time.LocalDate;
import java.util.List;

// Domain Service
public class BookRecruiter {
    public Interview planInterview(
            LocalDate availability, Candidate candidate, List<Recruiter> allRecruiters) {
        Recruiter recruiter = new Recruiter();
        List<Recruiter> availableRecruiters = recruiter.getAvailableRecruiters(availability, allRecruiters);
        List<String> candidateSkills = candidate.getSkills();
        Recruiter appropriateRecruiter = candidate.findAppropriateRecruiter(availableRecruiters, candidateSkills);
        appropriateRecruiter.bookAvailability(availability);
        return new Interview().getInterview(availability, candidate, appropriateRecruiter);
    }
}
