import org.mariuszgromada.math.mxparser.Function;
import org.mariuszgromada.math.mxparser.mXparser;

public class Funcao {

    public double bissecao(double x1, double x2, double e, String func) {
        Function f = new Function("f(x) = " + func);
        f.checkSyntax();
        mXparser.consolePrintln(f.getErrorMessage());

        //calcula a estimativa de iterações
        double max_iteracao = Math.round(Math.log(x2 - x1) - Math.log(e)) / Math.log(2);

        //calcula a metade do intervalo (a+b)/2
        double x_medio = 0;
        double x_old;
        double erro_estimado = 0;
        double num_iteracao = 0;

        //continua as iterações enquanto o erro estimado for maior que o erro desejado
        //ou enquanto o numero de iterações for menor que o esperado
        while (erro_estimado >= e || (num_iteracao <= max_iteracao)) {

            //Verifica se há uma raiz localizada no intervalo, através do teorema de bolzano
            double bolzano = f.calculate(x1) * f.calculate(x2);
            if (bolzano > 0) {
                return 0;
            }

            //armazena o x medio da iteração anterior em uma variavel
            x_old = x_medio;

            //calcula um novo x medio
            x_medio = (x1 + x2) / 2;

            //caso o x_medio seja a raiz, ele é retornado
            if (f.calculate(x_medio) == 0) {
                return x_medio;
            }

            //faz a verificação dos sinais e aponta qual será o novo intervalo superior ou inferior
            double teste = f.calculate(x1) * f.calculate(x_medio);
            if (teste < 0) {
                x2 = x_medio;
            } else {
                x1 = x_medio;
            }

            //faz o erro estimado entre o x_medio atual e o anterior
            erro_estimado = Math.abs(x_medio - x_old) / Math.abs(x_medio);
            num_iteracao++;
        }

        //ao final das iterações retorna a raiz encontrada
        return x_medio;
    }

}
