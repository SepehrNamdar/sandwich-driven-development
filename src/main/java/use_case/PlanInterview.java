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

    // Use Case -> Sandwich pattern applied
    public Interview plan(String candidateId, LocalDate availability) {
        Candidate candidate = candidates.findById(candidateId); // is a shared state ? Yes
        List<Recruiter> availableRecruiters =
                recruiters.findRecruiterByAvailability(availability); // Is a shared state ? Yes

        Interview interview = planInterview(availability, candidate, availableRecruiters);

        recruiters.bookAvailability(interview.getRecruiter(), availability);    // is a shared state ? Yes
        interviews.save(interview);
        return interview;
    }

    private Interview planInterview(LocalDate availability, Candidate candidate, List<Recruiter> availableRecruiters) {
        List<String> candidateSkills = candidate.getSkills();   // is a shared state ? No

        Optional<Recruiter> recruiter = availableRecruiters.stream()
                .filter(availableRecruiter ->
                        availableRecruiter.getSkills().containsAll(candidateSkills))
                .findFirst();   // Is a shared state ?  No

        Recruiter appropriateRecruiter = recruiter.orElseThrow(AnyRecruiterFoundException::new);

        Interview interview = new Interview();
        interview.setCandidate(candidate);
        interview.setRecruiter(appropriateRecruiter);
        interview.setInterviewDate(availability);
        return interview;
    }
}
