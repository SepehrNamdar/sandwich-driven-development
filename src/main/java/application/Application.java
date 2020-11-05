package application;

import java.time.LocalDate;
import java.util.List;

public class Application {
;
    private final CandidateRepository candidates;
    private final RecruiterRepository recruiters;

    public Application(CandidateRepository candidates, RecruiterRepository recruiters) {
        this.candidates = candidates;
        this.recruiters = recruiters;
    }

    public Interview planInterview(String candidateId, LocalDate availability) {
        Candidate candidate = candidates.findById(candidateId);
        List<String> candidateSkills = candidate.getSkills();

        List<Recruiter> availableRecruiters =
                recruiters.findRecruiterByAvailability(availability);
        Recruiter appropriateRecruiter = new Recruiter();
        for (Recruiter availableRecruiter : availableRecruiters) {
            List<String> recruiterSkills = availableRecruiter.getSkills();
            if (recruiterSkills.containsAll(candidateSkills)) {
                appropriateRecruiter = availableRecruiter;
            }
        }

        Interview interview = new Interview();
        interview.setCandidate(candidate);
        interview.setRecruiter(appropriateRecruiter);
        interview.setInterviewDate(availability);

        return interview;
    }
}
