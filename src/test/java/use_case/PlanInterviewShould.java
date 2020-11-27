package use_case;

import model.Interview;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static java.time.LocalDate.of;
import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

public class PlanInterviewShould {

    @Test
    void works() {
        Assertions.assertThat(true).isTrue();
    }
}
