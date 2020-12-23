package use_case;

import model.Candidate;
import model.Interview;
import model.Recruiter;

import java.time.LocalDate;
import java.util.List;

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
        List<Recruiter> allRecruiters = recruiters.getAllRecruiters();

        Recruiter appropriateRecruiter = candidate.bookRecruiter(availability, allRecruiters);
        Interview interview = new Interview(candidate, appropriateRecruiter, availability);

        interviews.save(interview);
        return interview;
    }

}
