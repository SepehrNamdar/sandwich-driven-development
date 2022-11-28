package model;

import java.time.LocalDate;
import java.util.List;

// Domain Service
public class InterviewService {

    public Interview getInterview(LocalDate availability,
                                  Candidate candidate,
                                  List<Recruiter> availableRecruiters,
                                  RecruiterRepository recruiters) {
        Recruiter appropriateRecruiter = candidate.findRecruiterAmong(availableRecruiters);

        Recruiter r = recruiters.bookAvailability(appropriateRecruiter, availability);// Shared State ? OUI

        Interview interview = new Interview();
        interview.setCandidate(candidate);
        interview.setRecruiter(r);
        interview.setInterviewDate(availability);
        return interview;
    }
}
