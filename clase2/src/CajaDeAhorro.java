/*Ejercicio 1
Implemente una clase llamada CajaDeAhorro, cuyo estado interno esté
representado por un número de caja de ahorro y un saldo monetario. Se debeen
proveer operaciones para averiguar el saldo y para realizar depósitos y
extracciones*/


public class CajaDeAhorro {

    private int numCaja;
    private int saldo;

    public CajaDeAhorro(int num_caja, int saldo_inicial){
        numCaja = num_caja;
        saldo= saldo_inicial;
    }

    public int getSaldo(){
        return saldo;
    }

    public int depositar(int monto_deposito){
        saldo += monto_deposito;

        return saldo;

    }

    public int extraer(int monto_extraccion){
        saldo -= monto_extraccion;

        return saldo;
    }

}
