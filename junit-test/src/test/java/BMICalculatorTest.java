import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BMICalculatorTest {


    @Nested
    class isDietRecommendedTest {

        @Test
        void should_ReturnTrue_When_DietRecommended() {
            //given
            double weight = 63;
            double height = 1.63;
            //double height = 0.0;

            //when
            boolean recommended = BMICalculator.isDietRecommended(weight, height);

            //then
            assertFalse(recommended);
        }

        @Test
        void should_ReturnFalse_When_DietNotRecommended() {
            //given
            double weight = 59.0;
            double height = 1.67;

            //when
            boolean recommended = BMICalculator.isDietRecommended(weight, height);

            //then
            assertFalse(recommended);
        }

        /*@Test
        void should_ThrowArithmeticException_When_HeightZero() {
            //given
            double weight = 50.0;
            double height = 0.0;

            //when
            Executable executable = () -> BMICalculator.isDietRecommended(weight, height);

            assertThrows(ArithmeticException.class, executable);

        }*/
    }

    @Nested
    class findCoderWithWorstBMI {

        @Test
        @DisplayName("sample method display name")
        void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
            //given
            List<Coder> coders = new ArrayList<>();
            coders.add(new Coder(63.0, 1.63));
            coders.add(new Coder(65.0, 1.61));
            coders.add(new Coder(76.0, 1.63));

            //when
            Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

            //then
            //if we just have assertEquals then if the first statement went wrong we can not understand if the second is correct or not because it doesnt even execute -> so use assertAll
            assertAll(
                    () -> assertEquals(76.0, coderWorstBMI.getWeight()),
                    () -> assertEquals(1.63, coderWorstBMI.getHeight())
            );
        }

        @Test
        void should_ReturnNullWorstBMICoder_When_CoderListEmpty() {
            //given
            List<Coder> coders = new ArrayList<>();

            //then
            Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

            //when
            assertNull(coderWorstBMI);
        }
    }

    @Nested
    class getBMIScores {
        @Test
        void should_ReturnCorrectBMiScores_When_CoderListNotEmpty() {
            //given
            List<Coder> coders = new ArrayList<>();
            coders.add(new Coder(63.0, 1.63));
            coders.add(new Coder(65.0, 1.61));
            coders.add(new Coder(76.0, 1.63));
            double[] bmiScores = {24.0, 25.0, 29.0};

            //when
            double[] expectedScores = BMICalculator.getBMIScore(coders);

            //then
            assertArrayEquals(expectedScores, bmiScores);
        }
    }
}
