package model;

import use_case.RecruiterRepository;

import java.time.LocalDate;
import java.util.List;

// Application Service
public class BookRecruiter {

    public Recruiter findRecruiter(
            LocalDate availability, Candidate candidate, RecruiterRepository recruiters) {
        List<Recruiter> allRecruiters = recruiters.findAllRecruiters();
        Recruiter appropriateRecruiter = candidate.findAppropriateRecruiter(availability, allRecruiters);
        appropriateRecruiter.book(availability);
        return recruiters.updateRecruiter(appropriateRecruiter);
    }
}
