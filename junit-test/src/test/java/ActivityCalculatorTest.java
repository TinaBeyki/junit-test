import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/*
TDD -> test driven development
first we write all the unit test that fails then try to implement the test in a way that all unit test invokes correctly
 */
public class ActivityCalculatorTest {

    @Test
    void should_ReturnBad_When_AvgBelow20() {
        //given
        int weeklyCardioMins = 40;
        int weeklyWorkouts = 1;

        //when
        String actual = ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkouts);

        //then
        assertEquals("bad", actual);

    }

    @Test
    void should_ReturnAverage_When_AvgBetween20And40() {
        //given
        int weeklyCardioMins = 40;
        int weeklyWorkouts = 3;

        //when
        String actual = ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkouts);

        //then
        assertEquals("average", actual);


    }

    @Test
    void should_ReturnGood_When_AvgAbove40() {
        //given
        int weeklyCardioMins = 40;
        int weeklyWorkouts = 7;

        //when
        String actual = ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkouts);

        //then
        assertEquals("good", actual);

    }

    @Test
    @Disabled
    void should_ThrowException_When_InputBelowZero() {
        //given
        int weeklyCardioMins = -40;
        int weeklyWorkouts = 1;

        //when
        Executable executable = () -> ActivityCalculator.rateActivityLevel(weeklyCardioMins, weeklyWorkouts);

        //then
        assertThrows(RuntimeException.class, executable);


    }
}
