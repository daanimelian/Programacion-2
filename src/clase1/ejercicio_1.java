package src.clase1;

public class ejercicio_1 {

   public static void main(String[] args) {

       int a,b,c;

       a=2;
       a++;

       System.out.println("El resultado del ejercicio a) es: " + a);

       a=2;
       b=a++;

       System.out.println("El resultado del ejercicio b) es: " + a + " " + b);

       a=2;
       b=++a;

       System.out.println("El resultado del ejercicio c) es: " + a + " " + b);

       a=2;
       b=1;
       b+=a;
       System.out.println("El resultado del ejercicio d) es: " + a + " " + b);

       b=1;
       b*=5;
       System.out.println("El resultado del ejercicio e) es: " + b);

       a=2;
       b += --a + 5;
       System.out.println("El resultado del ejercicio f) es: " + a + " "+ b);

       b=2;
       a+=b--;
       System.out.println("El resultado del ejercicio g) es: " + a + " "+ b);

       a=2;
       b=3;
       c=5;

       a++;
       b+=a;
       c*=b;
       b-=3;
       a%=2;
       c/=5;
       System.out.println("El resultado del ejercicio h) es: " + a + " "+ b+ " " + c);


       a=1;
       b=2;
       b++;
       b=++a;
       a*=2;
       b+=a;
       a=++b +2;
       System.out.println("El resultado del ejercicio i) es: " + a+ " " + b);


       a=1;
       b=4;
       a++;
       b+=a;
       a*=4;
       b-=a;
       ++b;
       a=++b;
       b=--a+b;
       System.out.println("El resultado del ejercicio j) es: " + a+ " " + b);

   }


}
