package application;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Application {

    private final CandidateRepository candidates;
    private final RecruiterRepository recruiters;
    private final InterviewRepository interviews;

    public Application(
            CandidateRepository candidates, RecruiterRepository recruiters, InterviewRepository interviews) {
        this.candidates = candidates;
        this.recruiters = recruiters;
        this.interviews = interviews;
    }

    public Interview planInterview(String candidateId, LocalDate availability) {
        Candidate candidate = candidates.findById(candidateId);
        List<String> candidateSkills = candidate.getSkills();

        List<Recruiter> availableRecruiters =
                recruiters.findRecruiterByAvailability(availability);

        Optional<Recruiter> recruiter = availableRecruiters.stream()
                .filter(availableRecruiter -> availableRecruiter.getSkills().containsAll(candidateSkills))
                .findFirst();

        Interview interview = new Interview();
        interview.setCandidate(candidate);
        interview.setRecruiter(recruiter.orElseThrow(AnyRecruiterFoundException::new));
        interview.setInterviewDate(availability);

        interviews.save(interview);
        return interview;
    }
}
