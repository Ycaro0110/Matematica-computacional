import org.mariuszgromada.math.mxparser.*;

import java.util.Scanner;


public class Principal {

    public static void main(String[] args) {

        boolean isCallSuccessful = License.iConfirmNonCommercialUse("Ycaro");
        boolean isConfirmed = License.checkIfUseTypeConfirmed();
        String message = License.getUseTypeConfirmationMessage();

        mXparser.consolePrintln("isCallSuccessful = " + isCallSuccessful);
        mXparser.consolePrintln("isConfirmed = " + isConfirmed);
        mXparser.consolePrintln("message = " + message);


        Bissecao m1 = new Bissecao();
        Secante m2 = new Secante();

        Scanner teclado = new Scanner(System.in);
        System.out.println("expressão: ");
        String expressao = teclado.nextLine();

        System.out.println("x1: ");
        double x1 = teclado.nextDouble();
        System.out.println("x2: ");
        double x2 = teclado.nextDouble();
        System.out.println("erro: ");

        double erro = teclado.nextDouble();

        double result = m1.bisseccao(x1, x2, erro, expressao);

        if (result == 0) {
            System.out.println("Não há raízes neste intervalo");
        } else {
            System.out.println("A raiz é: " + result);
        }
        
        System.out.println("-------secante--------");
        double result2 = m2.secante(x1, x2, erro, expressao);

        System.out.println(result2);

    }
}
