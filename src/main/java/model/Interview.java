package model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

// Aggregate
public class Interview {
    private Candidate candidate;
    private Recruiter recruiter;
    private LocalDate interviewDate;

    public Interview getInterview(LocalDate availability, Candidate candidate, List<Recruiter> availableRecruiters) {
        List<String> candidateSkills = candidate.getSkills();   // Shared state ? NON

        Recruiter appropriateRecruiter = candidate.getAppropriateRecruiter(availableRecruiters, candidateSkills);

        Interview interview = new Interview();
        interview.setCandidate(candidate);
        interview.setRecruiter(appropriateRecruiter);
        interview.setInterviewDate(availability);
        return interview;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public LocalDate getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(LocalDate interviewDate) {
        this.interviewDate = interviewDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interview interview = (Interview) o;
        return Objects.equals(candidate, interview.candidate) &&
                Objects.equals(recruiter, interview.recruiter) &&
                Objects.equals(interviewDate, interview.interviewDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidate, recruiter, interviewDate);
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
