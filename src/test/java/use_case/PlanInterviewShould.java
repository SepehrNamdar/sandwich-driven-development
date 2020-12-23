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
    void works() {
        verifyAllCombinations(
                this::getInterview,
                new String[] {"001", "123", "456", "789", "bad_id", null, ""},
                new LocalDate[] {
                        of(2021, 2, 21),
                        of(2021, 2, 22),
                        of(2021, 2, 20)});
    }

    private Interview getInterview(String candidateId, LocalDate interviewDate) {
        PlanInterview planInterview = new PlanInterview(
                new FakeCandidates(), new FakeRecruiters(), new FakeInterview());
        return planInterview.plan(candidateId, interviewDate);
    }
}
