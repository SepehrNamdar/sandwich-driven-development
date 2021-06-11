package use_case;

import model.*;

import java.time.LocalDate;
import java.util.List;

// Application Service
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

    // Use Case
    public Interview plan(String candidateId, LocalDate availability) {
        Candidate candidate = candidates.findById(candidateId); // Shared state?  OUI
        List<Recruiter> allRecruiters = recruiters.findAllRecruiters();

        Interview interview =
                new Interview().getInterview1(availability, candidate, allRecruiters);

        interviews.save(interview);
        return interview;
    }
}
