package main.java.ejercicios;

import java.util.ArrayList;

enum TipoRentabilidad{
    DIARIA, MENSUAL, ANUAL
}

abstract class CuentasBancarias{
    protected String nombreCuenta;
    protected int numeroCuenta;
    protected double saldo;

    public CuentasBancarias(String nombreCuenta, int numeroCuenta, double saldo) {
        this.nombreCuenta = nombreCuenta;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
    public abstract void presentarse();
    public abstract void mostrarSaldo();
    public abstract double calcularIntereses();

    public int getCuenta(){
        return this.numeroCuenta;
    }
    public double getSaldo() { return this.saldo;}
    public void setSaldo(double saldo) {this.saldo = saldo;}

    public double aumentarSaldo(double nuevoMonto){
        double montoExistente = getSaldo();
        double nuevoSaldo = montoExistente+nuevoMonto;
        setSaldo(nuevoSaldo);
        return getSaldo();
    }
    public double retirarSaldo(double saldoRetirar){
        if (saldoRetirar> this.saldo){
            throw new RuntimeException("Saldo insuficiente para realizar esta operación");
        } else{
            double nuevoMonto = this.saldo - saldoRetirar;
            setSaldo(nuevoMonto);
        }
        return getSaldo();
    }
}

class CuentaAhorro extends CuentasBancarias{
    static final double INTERES = 0.0125;
    TipoRentabilidad rentabilidad;

    public CuentaAhorro(String nombre, int numeroCuenta, double saldo, TipoRentabilidad rentabilidad) {
        super(nombre, numeroCuenta, saldo);
        this.rentabilidad = rentabilidad;
    }
    @Override
    public void presentarse(){
        System.out.printf("Nombre cuenta: %s \nNumero cuenta: %d\nSaldo: %f\nTipo Rentabilidad:%s", nombreCuenta, numeroCuenta, saldo, rentabilidad);
    }

    @Override
    public void mostrarSaldo(){
        System.out.println(super.saldo);
    }

    @Override
    public double calcularIntereses(){
        /* Sería interesante que en el futuro hicieramos refactor y que añadamos fecha creacion a la cuenta
        y que simulemos que pasen días, meses, años, y que calculemos el interes acumulado.
        deberemos implementar una función de calcular días transcurridos, y determinar cierres de día, de mes, y de años
        para que corran sobre la composición del interes sobre el saldo.
       */
        return super.saldo * INTERES;
    }
}

class CuentaCorriente extends CuentasBancarias{
    static final double COMISION_MENSUAL = 7500;

    public CuentaCorriente(String nombreCuenta, int numeroCuenta, double saldo) {
        super(nombreCuenta, numeroCuenta, saldo);
    }

    public void presentarse(){
        System.out.printf("Nombre cuenta: %s \nNumero cuenta: %d\nSaldo: %f", nombreCuenta, numeroCuenta, saldo);
    }

    @Override
    public void mostrarSaldo(){
        System.out.println(super.saldo);
    }
    @Override
    public double calcularIntereses(){

        return COMISION_MENSUAL;
    }

}

public class SistemaBancario {
    public static void main(String[] args) {
        ArrayList<CuentasBancarias> cuentas = new ArrayList<>();


        CuentaAhorro nc = new CuentaAhorro(
                "Cuenta ahorro maxima",
                23241,
                1500000,
                TipoRentabilidad.DIARIA
        );
       CuentaCorriente cc = new CuentaCorriente(
               "Cuenta corriente común",
               114543434,
               800000
       );
        cuentas.add(nc);
        cuentas.add(cc);
        for(CuentasBancarias cb: cuentas){
            cb.presentarse();
            System.out.println("\n");
        }
    }
}
