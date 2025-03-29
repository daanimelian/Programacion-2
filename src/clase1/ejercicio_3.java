package src.clase1;

public class ejercicio_3 {



//a. Reciba un número y determine si es par.

    public boolean esPar(int num){

        boolean es_par;

        es_par = (num%2 ==0 );

        return es_par;
    }

//b. Reciba un número y determine si es múltiplo de 5 o 7.

    public boolean esMult5o7(int num){
        boolean es_mult;

        es_mult = ((num % 7 ==0) || (num % 5 ==0));

        return es_mult;
    }

//c. Reciba dos números y retorne el mayor de ellos.

    public int esMayor(int num_1, int num_2){
        int mayor=num_2;

        if(num_1>num_2){
            mayor=num_1;
        }

        return mayor;
    }

//d. Reciba tres números y retorne el mayor de los tres.

    public int esMayor3(int num_1, int num_2, int num_3){
        int mayor=num_2;

        if(num_1>num_2 && num_1>num_3){
            mayor=num_1;
        }
        else if(num_3>num_1 && num_3>num_2){

            mayor=num_3;
        }

        return mayor;
    }


//e. Reciba un número entre 0 y 10, y si el número está entre 0 y 4 muestre “desaprobado”, si está entre 5 y 6 muestre “suspenso”, y si es mayor que 6 muestre “aprobado”.

    public void estaAprobado(int nota){
        if(0<=nota && nota<=4){
            System.out.println("desaprobado");
        }
        else if(4<nota && nota<=6){
            System.out.println("suspenso");
        }
        else if(6<nota && nota<=10){
            System.out.println("aprobado");
        }
        else{
            System.out.println("La nota debe estar entre 0 y 10.");
        }
    }

//f. Muestre por pantalla todos los números entre 0 y 100.

    public void numHasta100(){
        int i=0;
        while(i<101){
            System.out.println(i);
            i++;
        }

    }

//g. Reciba un número N, y muestre por pantalla todos los enteros entre 0 y N que sean pares.

    public void paresHastaN(int num){
        int i=0;

        while(i<=num){

            if(i%2==0){
                System.out.println(i);
            }

            i++;

        }

    }
//h. Reciba un número N, y retorne la sumatoria desde 0 a N.
//i. Reciba un número N, y retorne la suma de sus dígitos
//j. Determine si, dado un número N = dm,dm-1, ..., d1 y un dígito d, d=di para 1<= i <= m
//k. Determine si un número dado es primo.
//l. Determine si un número dado es perfecto; un número es perfecto si la suma de los divisores del número (incluyendo al 1 y excluyendo al número) es igual al número. Ej.: suma de divisores de 6 =>1 + 2 + 3 = 6 => es perfecto.*/



}
