package use_case;

import model.*;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;

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
        List<Recruiter> allRecruiters = recruiters.findAllRecruiters();

        List<Recruiter> availableRecruiters = getRecruiters(availability, allRecruiters);

        Interview interview = new Interview().getInterview(availability, candidate, availableRecruiters);

        interviews.save(interview);
        return interview;
    }

    private List<Recruiter> getRecruiters(LocalDate availability, List<Recruiter> allRecruiters) {
        return allRecruiters.stream()
                .filter(recruiter -> recruiter.getAvailabilities().contains(availability))
                .collect(toList());
    }

}
