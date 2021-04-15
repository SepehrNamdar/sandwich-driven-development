package use_case;

import model.Interview;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalDate.of;
import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

public class PlanInterviewShould {

    @Test
    void find_an_available_recruiter_who_can_test_candidate() {
        String[] candidateIds = {"123", "456", "789", "", null, "BAD-ID"};
        LocalDate[] interviewDates = {
                of(2021, 2, 20),
                of(2021, 2, 21),
                of(2021, 2, 22),
                of(2033, 2, 20),
                of(1789, 2, 20),
                null
        };

        verifyAllCombinations(this::planInterview, candidateIds, interviewDates);
    }

    private Interview planInterview(String candidateId, LocalDate interviewDate) {
        // GIVEN
        PlanInterview interview =
                new PlanInterview(new FakeCandidates(), new FakeRecruiters(), new FakeInterview());

        // WHEN
        return interview.plan(candidateId, interviewDate);
    }

}
