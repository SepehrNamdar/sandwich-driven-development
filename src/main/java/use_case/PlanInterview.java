package use_case;

import model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public Interview plan(String candidateId, LocalDate availability) {
        Candidate candidate = candidates.findById(candidateId); // Shared State ? OUI
        List<Recruiter> availableRecruiters =                   // Shared State ? OUI
                recruiters.findRecruiterByAvailability(availability);

        Interview interview = new InterviewService().getInterview(availability, candidate, availableRecruiters, recruiters);

        interviews.save(interview);
        return interview;
    }

}
