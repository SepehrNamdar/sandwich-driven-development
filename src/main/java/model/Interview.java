package model;

import use_case.AnyRecruiterFoundException;
import use_case.RecruiterRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Interview {
    private Candidate candidate;
    private Recruiter recruiter;
    private LocalDate interviewDate;

    public Interview(
            LocalDate availability, Candidate candidate, List<Recruiter> availableRecruiters, RecruiterRepository recruiters) {
        List<String> candidateSkills = candidate.getSkills();

        Recruiter appropriateRecruiter = availableRecruiters.stream()
                .filter(availableRecruiter -> availableRecruiter.canTest(candidateSkills))
                .findFirst()
                .orElseThrow(AnyRecruiterFoundException::new);

        Recruiter recruiter = recruiters.bookAvailability(appropriateRecruiter, availability);

        this.candidate = candidate;
        this.recruiter = recruiter;
        this.interviewDate = availability;
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
