package use_case;

import model.Candidate;
import model.Interview;
import model.Recruiter;

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
        Candidate candidate = candidates.findById(candidateId);
        List<String> candidateSkills = candidate.getSkills();

        List<Recruiter> availableRecruiters =
                recruiters.findRecruiterByAvailability(availability);

        Optional<Recruiter> recruiter = availableRecruiters.stream()
                .filter(availableRecruiter -> availableRecruiter.getSkills().containsAll(candidateSkills))
                .findFirst();

        Recruiter appropriateRecruiter = recruiter.orElseThrow(AnyRecruiterFoundException::new);
        recruiters.bookAvailability(appropriateRecruiter, availability);

        Interview interview = new Interview();
        interview.setCandidate(candidate);
        interview.setRecruiter(appropriateRecruiter);
        interview.setInterviewDate(availability);

        interviews.save(interview);
        return interview;
    }
}
