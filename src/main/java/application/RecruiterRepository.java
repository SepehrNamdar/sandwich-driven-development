package application;

import java.time.LocalDate;
import java.util.List;

public interface RecruiterRepository {
    List<Recruiter> findRecruiterByAvailability(LocalDate availability);
}
