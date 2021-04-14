package model;

import model.Recruiter;

import java.time.LocalDate;
import java.util.List;

public interface RecruiterRepository {
    List<Recruiter> findRecruiterByAvailability(LocalDate availability);

    void bookAvailability(Recruiter appropriateRecruiter, LocalDate availability);
}
