import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedBMICalculatorTest {

    @ParameterizedTest
    @ValueSource(doubles = {/*70.0, */89.0, 95.0, 110.0})
    @Disabled
    void should_ReturnTrue_When_DietRecommended(double coderWeight) {
        //given
        double height = 1.72;

        //when
        boolean recommended = BMICalculator.isDietRecommended(coderWeight, height);

        //then
        assertTrue(recommended);
    }


    /*
    csvSource does not refer to csv file it simply stands for comma separated values
     */
    @ParameterizedTest(name = "weight = {0}, height = {1}")
    @CsvSource(value = {"89.0, 1.72", "95.0, 1.75", "110.0, 1.78"})
    @DisplayName(">> 1")
    @DisabledOnOs(OS.LINUX)
    void should_ReturnTrue_When_DietRecommended1(double coderWeight, double coderHeight) {
        //given

        //when
        boolean recommended = BMICalculator.isDietRecommended(coderWeight, coderHeight);

        //then
        assertTrue(recommended);
    }


    /*
    we want to use parameters directly from csv file not csvSource
    numLineToSkip = 1 because the first line is the header not the data
     */
    @ParameterizedTest(name = "weight = {0}, height = {1}")
    @CsvFileSource(resources = "/diet_recommended_input_data.csv", numLinesToSkip = 1)
    @DisplayName(">> 2")
    void should_ReturnTrue_When_DietRecommended2(double coderWeight, double coderHeight) {
        //given

        //when
        boolean recommended = BMICalculator.isDietRecommended(coderWeight, coderHeight);

        //then
        assertTrue(recommended);
    }


}
