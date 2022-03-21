import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

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

    //Tres números, delimitados de cualquier manera, devuelven la suma
    @Test
    void tresNumerosDelimitadosComoSeaReturnSuma()throws Exception
    {
        assertThat(stringCalculator.sum("8\n5,1"),is(14));
        assertThat(stringCalculator.sum("9\n1\n5"),is(15));
        assertThat(stringCalculator.sum("10,1,10"),is(21));
    }

    //Los números negativos arrojan una excepción

    @Test
    public void negativeNumberException()throws Exception
    {
        stringCalculator.sum("-1,-1");
    }

    // Los números superiores a 1000 se ignoran
    @Test
    void numerosMayorA1000Ignorados()throws Exception
    {
        assertThat(stringCalculator.sum("2,1000"), is(1002));
        assertThat(stringCalculator.sum("2,1001"), is(2));
    }

    //Se puede definir un solo delimitador de caracteres en la primera línea (p. Ej., // # para un "#" como delimitador)

    @Test
    void delimitadorPrimeraLinea()throws Exception
    {
        assertThat(stringCalculator.sum("#2#10"), is(12));
    }

    //Se puede definir un delimitador de varios caracteres en la primera línea (p. Ej., // [###] para "###" como delimitador)
    @Test
    void variosDelimitadoresPrimeraLinea()throws Exception
    {
        assertThat(stringCalculator.sum("[###]2#10"), is(12));
        assertThat(stringCalculator.sum("!!![###]2#10"), is(12));

    }

    //Se pueden definir muchos delimitadores de uno o varios caracteres (cada uno entre corchetes)
    @Test
    void multipleDelimitadoresPrimeraLinea()throws Exception
    {
        assertThat(stringCalculator.sum("[###][****]2#10"), is(12));
        assertThat(stringCalculator.sum("[###][!!!][###]2#10"), is(12));

    }









}