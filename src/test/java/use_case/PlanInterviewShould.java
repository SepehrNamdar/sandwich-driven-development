package use_case;

import model.Interview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalDate.of;
import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

public class PlanInterviewShould {

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
    void find_first_available_recruiter_who_can_test_candidate() {
        verifyAllCombinations(
                this::planInterview,
                new String[] {"123", "456", "789", null, "", "XYZ", "456-por"},
                new LocalDate[] {
                        of(2021, 2, 20),
                        of(2021, 2, 21),
                        of(2021, 2, 22)});
    }

    private Interview planInterview(String candidateId, LocalDate availability) {
        PlanInterview planner = new PlanInterview(candidates, recruiters, interviews);
        return planner.plan(candidateId, availability);
    }

    private static class FakeInterviews implements InterviewRepository {
        @Override
        public void save(Interview interview) {

        }
    }
}
