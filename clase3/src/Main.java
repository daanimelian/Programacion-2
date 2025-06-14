package clase3.src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una cadena: ");
        String input = sc.nextLine();

        boolean capicua = metodos.isBalanced(input);

        System.out.println("El cadena es capicua: " + capicua);


    }

}
