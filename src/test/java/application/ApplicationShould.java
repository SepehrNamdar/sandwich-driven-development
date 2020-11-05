package application;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationShould {

    @Test
    void works() {
        Application application = new Application();
        assertThat(application.isWorking()).isTrue();
    }
}
