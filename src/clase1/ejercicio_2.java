package src.clase1;

public class ejercicio_2 {

    public static void main(String[] args) {
        int a, b;
        boolean v;

        a=1;
        b=2;
        v=(a++<b);

        System.out.println("El resultado del ejercicio a) es: " + "a=" + a + " b=" + b + " y v=" + v);


        a=1;
        b=2;
        v=(++a<b);
        System.out.println("El resultado del ejercicio b) es: "+ "a=" + a + " b=" + b + " y v=" + v);

        a=1;
        b=2;
        v=(++a>=b);
        System.out.println("El resultado del ejercicio c) es: " + "a=" + a + " b=" + b + " y v=" + v);


        a=1;
        v= (a%2 == 0);
        System.out.println("El resultado del ejercicio d) es: " + "a=" + a + " b=" + b + " y v=" + v);


        a=1;
        v= (a != 1);
        System.out.println("El resultado del ejercicio e) es: " + "a=" + a + " b=" + b + " y v=" + v);


        a=1;
        b=2;
        v=(b++<10 && a==1);
        System.out.println("El resultado del ejercicio f) es: " + "a=" + a + " b=" + b + " y v=" + v);


        a=1;
        b=2;
        v=(b==1 && a>=1);
        System.out.println("El resultado del ejercicio g) es: " + "a=" + a + " b=" + b + " y v=" + v);


        a=1;
        b=2;
        v=(b<10 || a++==2);
        System.out.println("El resultado del ejercicio h) es: " + "a=" + a + " b=" + b + " y v=" + v);


        a=1;
        b=2;
        v=(--b<=1 || a<=10);
        System.out.println("El resultado del ejercicio i) es: " + "a=" + a + " b=" + b + " y v=" + v);


        a=1;
        b=2;
        v=(a--==2 || b==1);
        System.out.println("El resultado del ejercicio j) es: " + "a=" + a + " b=" + b + " y v=" + v);


        a=1;
        b=2;
        v=!(a==1 && ++b==1);
        System.out.println("El resultado del ejercicio k) es: " + "a=" + a + " b=" + b + " y v=" + v);

    }
}
