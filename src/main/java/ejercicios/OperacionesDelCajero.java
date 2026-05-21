package main.java.ejercicios;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

interface IOperaciones{
    void retirarDinero(Scanner sc, ArrayList<CuentasBancarias>cuentas);
    void depositarDinero(Scanner sc, ArrayList<CuentasBancarias>cuentas);
    void consultarEstado(Scanner sc, ArrayList<CuentasBancarias>cuentas);
}
class Cajero implements IOperaciones{
    static final int RETIRO_MAXIMO = 1000000;

    public Cajero() {
    }

    public int pedirCuenta(Scanner sc){
        System.out.printf("\nIngrese el número de la cuenta sobre la que desea operar: \n");
        int cuenta = sc.nextInt();   // Sería interesante acá poner una validación con excepcion por tipo de dato, para la proxima.
        return cuenta;
    }

    public double pedirMonto(Scanner sc){
        System.out.println("\nIngrese el monto a depositar");
        int monto = sc.nextInt();
        return monto;

    }

    public  Optional<CuentasBancarias> buscarCuenta(int cuenta, ArrayList<CuentasBancarias> lista) {
        Optional<CuentasBancarias> cuentaEncontrada = lista.stream()
                .filter(u -> u.getCuenta() == cuenta)
                .findFirst();

        if (cuentaEncontrada.isEmpty()){
            System.out.println("No se encontró ninguna cuenta asociada: "+cuentaEncontrada);
        } else{
            System.out.println("Busqueda realizada con éxito, cuenta encontrada\n");
        }
        return cuentaEncontrada;
    }

    public void consultarEstado(Scanner sc, ArrayList<CuentasBancarias>cuentas){
        int cuenta = pedirCuenta(sc);
        Optional<CuentasBancarias> cuentaEncontrada = buscarCuenta(cuenta, cuentas);
        CuentasBancarias cta = cuentaEncontrada.get();
        System.out.println("---> su saldo es de :");
        cta.mostrarSaldo();
    }

    public void depositarDinero(Scanner sc, ArrayList<CuentasBancarias>cuentas){
        int cuenta = pedirCuenta(sc);
        Optional<CuentasBancarias> cuentaEncontrada = buscarCuenta(cuenta, cuentas);
        CuentasBancarias cta = cuentaEncontrada.get();
        double monto = pedirMonto(sc);
        cta.aumentarSaldo(monto);
        System.out.println("---> su nuevo saldo es de :");
        cta.mostrarSaldo();

    }
    @Override
    public void retirarDinero(Scanner sc, ArrayList<CuentasBancarias>cuentas) {
        int cuenta = pedirCuenta(sc);
        Optional<CuentasBancarias> cuentaEncontrada = buscarCuenta(cuenta, cuentas);
        CuentasBancarias cta = cuentaEncontrada.get();
        double monto = pedirMonto(sc);
        if (monto <= RETIRO_MAXIMO){
            cta.retirarSaldo(monto);
            System.out.println("---> su nuevo saldo es de :\n");
        } else{
            System.out.println("El monto solicitado excede el máximo permitido");
        }
        cta.mostrarSaldo();
    }
}

public class OperacionesDelCajero {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        ArrayList<CuentasBancarias> cuentas = new ArrayList<>();
        CuentaAhorro nc = new CuentaAhorro("Cuenta ahorro maxima", 23241, 1500000, TipoRentabilidad.DIARIA);
        CuentaCorriente cc = new CuentaCorriente("Cuenta corriente común", 114543434, 800000);
        CuentaCorriente cr = new CuentaCorriente("Cuenta rut",123123,550000);
        cuentas.add(nc);
        cuentas.add(cc);
        cuentas.add(cr);

        while (!exit){
            System.out.print("\n\n==================================\n\n");
            System.out.println("\nIngrese 1 para consultar estado de cuenta.");
            System.out.println("\nIngrese 2 para realizar un depósito.");
            System.out.println("\nIngrese 3 para realizar un retiro.");
            System.out.println("\nIngrese 9 para apagar.");
            int input = sc.nextInt();
            System.out.print("\n\n\n");
            switch (input){
                case 1: {
                    System.out.println("======== OPERACIÓN CONSULTA DE ESTADO DE CUENTA ========");
                    Cajero nOperacion = new Cajero();
                    nOperacion.consultarEstado(sc, cuentas);
                    break;
                }
                case 2:{
                    System.out.println("======== OPERACIÓN DEPÓSITO DE DINERO ========");
                    Cajero nOperacion = new Cajero();
                    nOperacion.depositarDinero(sc, cuentas);

                    break;
                }
                case 3:{
                    System.out.println("======== OPERACIÓN RETIRO DE DINERO ========");
                    Cajero nOperacion = new Cajero();
                    nOperacion.retirarDinero(sc, cuentas);
                    break;
                }
                case 9:{
                    System.out.println("Hasta la proxima");
                    exit = true ;
                    break;
                }
                default:{
                    System.out.println("Opción ingresada es incorrecta.");
                    break;
                }
            }

        }
    }
}
