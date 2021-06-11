package use_case;

import model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PlanInterview {

    private final CandidateRepository candidates;
    private final RecruiterRepository recruiters;
    private final InterviewRepository interviews;

    public PlanInterview(
            CandidateRepository candidates, RecruiterRepository recruiters, InterviewRepository interviews) {
        this.candidates = candidates;
        this.recruiters = recruiters;
        this.interviews = interviews;
    }
    // Shared state
    public Interview plan(String candidateId, LocalDate availability) {
        Candidate candidate = candidates.findById(candidateId); // Shared state?  OUI
        List<Recruiter> availableRecruiters =
                recruiters.findRecruiterByAvailability(availability); // Shared state ? OUI

        Interview interview =
                new Interview().getInterview(availability, candidate, availableRecruiters, recruiters);

        interviews.save(interview);
        return interview;
    }
}
