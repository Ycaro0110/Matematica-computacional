import org.mariuszgromada.math.mxparser.*;
import java.util.Scanner;

public class Main {

    public static double bisseccao(double x1, double x2, double e, String func) {
        Function f = new Function("f(x) = " + func);
        f.checkSyntax();
        mXparser.consolePrintln(f.getErrorMessage());

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

    public static void main(String[] args) {


        boolean isCallSuccessful = License.iConfirmNonCommercialUse("Ycaro");
        boolean isConfirmed = License.checkIfUseTypeConfirmed();
        String message = License.getUseTypeConfirmationMessage();

        mXparser.consolePrintln("isCallSuccessful = " + isCallSuccessful);
        mXparser.consolePrintln("isConfirmed = " + isConfirmed);
        mXparser.consolePrintln("message = " + message);

        Scanner teclado = new Scanner(System.in);
        System.out.println("expressão: ");
        String expressao = teclado.nextLine();

        System.out.println("x1: ");
        int x1 = teclado.nextInt();
        System.out.println("x2: ");
        int x2 = teclado.nextInt();
        System.out.println("erro: ");

        double erro = teclado.nextDouble();

        double result = bisseccao(x1, x2, erro, expressao);

        if (result == 0) {
            System.out.println("Não há raízes neste intervalo");
        } else {
            System.out.println("A raiz é: " + result);
        }
    }
}
