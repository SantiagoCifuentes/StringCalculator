import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest
{
    public StringCalculator stringCalculator = new StringCalculator();


    //Una cadena vacía devuelve cero
    @Test
     void EmptyStringValidator() throws Exception
    {
        assertThat(stringCalculator.sum(""),is(0));

    }
    @Test
    //Un solo número devuelve el valor
    void singleNumberReturnItsValueTest() throws Exception
    {
        assertThat(stringCalculator.sum("8"),is(8));
        assertThat(stringCalculator.sum("9"),is(9));
    }

    //Dos números, delimitados por comas, devuelven la suma
    @Test
    void dosNumerosDelimitadosPorComasReturnSuma()throws Exception
    {
        assertThat(stringCalculator.sum("8,5"),is(13));
        assertThat(stringCalculator.sum("9,1"),is(10));
    }

    //Dos números, delimitados por saltos de línea, devuelve la suma
    @Test
    void dosNumerosDelimitadosPorSaltosDeLineaReturnSuma()throws Exception
    {
        assertThat(stringCalculator.sum("8\n5"),is(13));
        assertThat(stringCalculator.sum("9\n1"),is(10));
    }




}