import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DietPlannerTest {

    /*
    its not good to initial obj in unit test because then you must  initialize it each time in unit test
    and also not initialized in here cause all unit test must be independent
     */
    private DietPlanner dietPlanner;


    /*
    this function can have any name but must be static and it is used for operations that should be run exactly once before other unit tests are performed
    it is usually applied to operations that are too expensive to be run before
     */
    @BeforeAll
    static void beforeAll() {
        System.out.println("before all unit test");
    }

    /*
    this will be typically used to close database connections or stop servers
     */
    @AfterAll
    static void afterAll() {
        System.out.println("after all unit test");
    }

    //this function invokes before each unit test
    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void afterEach() {
        System.out.println("unit test done:)");
    }

    @Test
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        //given
        Coder coder = new Coder(75.0, 1.82, 26, Gender.Male);
        DietPlan expected = new DietPlan(2202, 110, 73, 275);

        //when
        DietPlan actual = dietPlanner.calculateDietPlan(coder);

        //then
        assertAll(
                () -> assertEquals(expected.getCalories(), actual.getCalories()),
                () -> assertEquals(expected.getProtein(), actual.getProtein()),
                () -> assertEquals(expected.getFat(), actual.getFat()),
                () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }

}
