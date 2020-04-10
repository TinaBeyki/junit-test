import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTimeout;

public class LimitedBMICalculatorTest {

    @Test
    void should_ReturnCoderWithWorstBMI_When_CoderListHas10000Elements() {
        //given
        List<Coder> coders = new ArrayList<>();
        for(int i = 0; i < 10000; i++){
            coders.add(new Coder(1.0 + i, 10.0 + i));
        }

        //when
        Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);

        //then
        assertTimeout(Duration.ofMillis(500), executable);
    }
}
