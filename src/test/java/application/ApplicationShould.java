package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;
import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

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
        verifyAllCombinations(
                this::planInterview,
                new String[] {"123", null},
                new LocalDate[] {now()});
    }

    private Interview planInterview(String candidateId, LocalDate availability) {
        Application application = new Application(candidates, recruiters, interviews);
        return application.planInterview(candidateId, availability);
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
