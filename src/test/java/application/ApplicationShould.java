package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationShould {

    private CandidateRepository candidates;
    private RecruiterRepository recruiters;
    private InterviewRepository interviews;

    @BeforeEach
    public void init() {
        candidates = new FakeCandidates();
        recruiters = new FakeRecruiters();
        interviews = new FakeInterviews();
    }

    @Test
    void works() {
        Application application = new Application(candidates, recruiters, interviews);

        Interview interview = application.planInterview("123", LocalDate.now());

        Recruiter expectedRecruiter = new Recruiter();
        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add(".Net");
        skills.add("PHP");
        skills.add("JS");
        expectedRecruiter.setSkills(skills);
        assertThat(interview.getRecruiter()).isEqualTo(expectedRecruiter);
    }

    private static class FakeCandidates implements CandidateRepository {
        @Override
        public Candidate findById(String candidateId) {
            Candidate candidate = new Candidate();
            List<String> skills = new ArrayList<>();
            skills.add(".Net");
            skills.add("Java");
            skills.add("PHP");
            skills.add("JS");
            candidate.setSkills(skills);
            return candidate;
        }
    }

    private static class FakeRecruiters implements RecruiterRepository {
        @Override
        public List<Recruiter> findRecruiterByAvailability(LocalDate availability) {
            List<Recruiter> availableRecruiters = new ArrayList<>();
            Recruiter mary = new Recruiter();
            List<String> skills = new ArrayList<>();
            skills.add("Java");
            skills.add(".Net");
            skills.add("PHP");
            skills.add("JS");
            mary.setSkills(skills);
            availableRecruiters.add(mary);
            return availableRecruiters;
        }
    }

    private static class FakeInterviews implements InterviewRepository {
        @Override
        public void save(Interview interview) {

        }
    }
}
