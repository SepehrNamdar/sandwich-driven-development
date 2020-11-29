package use_case;

import model.Candidate;
import model.Interview;
import model.Recruiter;

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

    public Interview plan(String candidateId, LocalDate availability) {
        Candidate candidate = candidates.findById(candidateId);
        List<Recruiter> availableRecruiters =
                recruiters.findRecruiterByAvailability(availability);

        Interview interview = new Interview(availability, candidate, availableRecruiters, recruiters);

        interviews.save(interview);
        return interview;
    }

}
