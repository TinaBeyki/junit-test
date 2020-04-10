import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

/*
you may come a cross situations when you want to run the same test multiple times
for example we have multiple threads
 */
public class RepeatedDietPlannerTest {

    private DietPlanner dietPlanner;

    @AfterEach
    void afterEach() {
        System.out.println("unit test done:)");
    }

    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
        System.out.println("unit test:)");
    }

    /*
    each repetition is treated as a separate unit test
     */
    //@RepeatedTest(10)
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        //given
         Coder coder = new Coder(75.0, 1.82, 26, Gender.Male);
         DietPlan expected = new DietPlan(2202, 110, 73, 275);

        //when
        DietPlan actual = dietPlanner.calculateDietPlan(coder);

        //then
        assertAll(
                () -> assertEquals(expected.getProtein(), actual.getProtein())
        );
    }


}
