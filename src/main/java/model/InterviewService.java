package model;

import java.time.LocalDate;
import java.util.List;

public class InterviewService {

    public Interview getInterview1(LocalDate availability, Candidate candidate, List<Recruiter> availableRecruiters, RecruiterRepository recruiters) {
        List<String> candidateSkills = candidate.getSkills();   // Shared state ? NON

        Recruiter appropriateRecruiter = candidate.getAppropriateRecruiter(availableRecruiters, candidateSkills);

        Recruiter recruiter = recruiters.bookAvailability(appropriateRecruiter, availability);// Shared state ? OUI

        Interview interview = new Interview().getInterview(availability, candidate, recruiter);
        return interview;
    }
}
