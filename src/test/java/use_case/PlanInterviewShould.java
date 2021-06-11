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
    void find_a_recruiter_who_can_test_the_candidate() {
        String[] candidateId = {"123", "456", "789", "BAD_ID", "", null} ;
        LocalDate[] interviewDate = {
                of(2021, 2, 20),
                of(2021, 2, 21),
                of(2021, 2, 22),
                of(3000, 2, 20),
                of(1700, 2, 20),
                null
        };

        CombinationApprovals.verifyAllCombinations(this::getInterview, candidateId, interviewDate);
    }

    private Interview getInterview(String candidateId, LocalDate interviewDate) {
        // GIVEN
        PlanInterview interview =
                new PlanInterview(new FakeCandidates(), new FakeRecruiters(), new FakeInterview());

        // WHEN
        return interview.plan(candidateId, interviewDate);
    }

    @Test
    void mutates_data_inside_recruiter_repository() {
        final FakeRecruiters recruitersRepository = new FakeRecruiters();
        PlanInterview interview = new PlanInterview(new FakeCandidates(), recruitersRepository, new FakeInterview());

        interview.plan("123", of(2021, 2, 20));

        Assertions.assertThat(recruitersRepository.recruiters).isEqualTo(new FakeRecruiters().recruiters);
    }
}
