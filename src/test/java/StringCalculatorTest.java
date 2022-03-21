import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest
{
    public StringCalculator stringCalculator = new StringCalculator();

    @Test
     void EmptyStringValidator() throws Exception
    {
        assertThat(stringCalculator.sum(""),is(0));

    }

}