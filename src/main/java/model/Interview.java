package model;

import java.time.LocalDate;

public class Interview {
    private final Candidate candidate;
    private final Recruiter recruiter;
    private final LocalDate interviewDate;

    public Interview(Candidate candidate, Recruiter recruiter, LocalDate interviewDate) {
        this.candidate = candidate;
        this.recruiter = recruiter;
        this.interviewDate = interviewDate;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "candidate=" + candidate +
                ", recruiter=" + recruiter +
                ", interviewDate=" + interviewDate +
                '}';
    }
}
