import org.mariuszgromada.math.mxparser.Function;
import org.mariuszgromada.math.mxparser.mXparser;

public class Funcao {

    public double bisseccao(double x1, double x2, double e, String func) {
        Function f = new Function("f(x) = " + func);
        f.checkSyntax();
        mXparser.consolePrintln(f.getErrorMessage());

        //calcula a estimativa de iterações
        double max_iteracao = Math.round(Math.log(x2 - x1) - Math.log(e)) / Math.log(2);
        double x_medio = 0;
        double num_iteracao = 0;

        while ((x2 - x1) / 2 >= e || (num_iteracao < max_iteracao)) {

            double bolzano = f.calculate(x1) * f.calculate(x2);
            if (bolzano > 0) {
                return 0;
            }
            x_medio = (x1 + x2) / 2;

            double teste = f.calculate(x1) * f.calculate(x_medio);

            if (f.calculate(x_medio) == 0) {
                return x_medio;
            }
            if (teste < 0) {
                x2 = x_medio;
            } else {
                x1 = x_medio;
            }
            num_iteracao++;
        }
        return x_medio;
    }

}
