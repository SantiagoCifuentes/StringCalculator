import java.util.ArrayList;

public class StringCalculator
{
    public int sum(String valor) throws Exception {

        if(valor.length() > 0) {
            int temp;
            String delimitador = null;

            try {
                temp = Integer.parseInt("" + valor.charAt(0));
            } catch(Exception e) {
                if(("" + valor.charAt(0)) == "-") {
                    delimitador = null;
                } else {
                    delimitador = "" + valor.charAt(0);
                }
            }

            String[] listaDividida = null;
            if(delimitador != null && delimitador == "-") {
                listaDividida = valor.substring(1, valor.length()).split("[,|\n]");
            } else {
                listaDividida = valor.replaceAll("[\\[.*\\]|#]", ",").split("[,|\n]");
            }

            ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
            int acumulador = 0;
            for(String elemento: listaDividida) {

                    int valorTemporal = Integer.parseInt(elemento);
                    if(valorTemporal < 0) {
                        throw new Exception("Excepción de número negativo");
                    }
                    if(valorTemporal > 1000) {
                        continue;
                    }
                    listaNumeros.add(valorTemporal);



            }
            for(Integer numero: listaNumeros) {
                acumulador += numero;
            }
            return acumulador;
        }
        return 0;
    }
}
