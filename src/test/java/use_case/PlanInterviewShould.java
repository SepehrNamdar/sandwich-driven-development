package use_case;

import model.Interview;
import org.approvaltests.combinations.CombinationApprovals;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalDate.of;
import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

public class PlanInterviewShould {

    @Test
    void find_a_recruiter_for_my_candidate() {
        // Inputs
        String[] candidateId = {"123", "456", "789", null, "bad_id"};
        LocalDate[] interviewDate = {
                of(2021, 2, 20),
                of(2021, 2, 21),
                of(2021, 2, 22),
                of(3000, 2, 20),
                of(1900, 2, 20),
                null
        };

        verifyAllCombinations(this::getInterview, candidateId, interviewDate);
    }

    private Interview getInterview(String candidateId, LocalDate interviewDate) {
        // Given
        PlanInterview planInterview =
                new PlanInterview(new FakeCandidates(), new FakeRecruiters(), new FakeInterview());

        // When
        return planInterview.plan(candidateId, interviewDate);
    }
}
