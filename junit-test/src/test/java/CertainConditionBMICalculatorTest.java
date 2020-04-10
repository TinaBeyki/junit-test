import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/*
you may need to write some unit tests that only make sense under certain condition
a very typical use case is when you have more than one execution environment for instance when you run
 */
public class CertainConditionBMICalculatorTest {

    private String environment = "dev";

    @Nested
    class findCoderWithWorstBMI {

        @Test
        void should_ReturnCoderWithWorstBMI_When_CoderListHas10000Elements() {
            //given
            //assumeTrue is similar to assertTrue but never fails the test
            assumeTrue(CertainConditionBMICalculatorTest.this.environment.equals("prod"));
            List<Coder> coders = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                coders.add(new Coder(1.0 + i, 10.0 + 1));
            }

            //when
            Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);

            //then
            assertTimeout(Duration.ofMillis(500), executable);
        }
    }
}
