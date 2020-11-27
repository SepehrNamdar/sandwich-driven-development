package use_case;

import model.Recruiter;

import java.util.List;

public interface RecruiterRepository {
    List<Recruiter> findAllRecruiters();

    Recruiter updateRecruiter(Recruiter recruiter);
}
