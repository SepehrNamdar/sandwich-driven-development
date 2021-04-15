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

    // Use Case -> Sandwich pattern applied
    public Interview plan(String candidateId, LocalDate availability) {
        Candidate candidate = candidates.findById(candidateId); // is a shared state ? Yes
        List<Recruiter> allRecruiters = recruiters.findAllRecruiters(); // Is a shared state ? Yes

        Interview interview = new BookRecruiter().planInterview(availability, candidate, allRecruiters);

        interviews.save(interview);
        return interview;
    }

}
