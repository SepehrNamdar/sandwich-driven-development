package model;

import model.Recruiter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public interface RecruiterRepository {
    List<Recruiter> findAllRecruiters();
}
