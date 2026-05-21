package main.java.ejercicios;

import java.util.ArrayList;

class MontoInvalidoException extends RuntimeException{
    public MontoInvalidoException(String mensaje) {super(mensaje);}
}

class SaldoException extends RuntimeException{
    public SaldoException(String mensaje) {super(mensaje);}
}

class LimiteSuperadoException extends RuntimeException{
    public LimiteSuperadoException(String mensaje) {super(mensaje);}
}
class CuentaInvalidaException extends RuntimeException{
    public CuentaInvalidaException(String mensaje){super(mensaje);}
}



interface Operaciones{
    void ejecutarOperacion();
}

class TransferenciaBancaria implements Operaciones{
    private double saldo;
    private double monto;
    private String cuentaDestino;

    public TransferenciaBancaria(double monto, String cuentaDestino) {
        this.saldo = 10000000;
        this.monto = monto;
        this.cuentaDestino = cuentaDestino;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }
    public void ejecutarOperacion(){

        //primero validamos que los montos recibidos son apropiados
        if(this.monto <=0){
            throw new MontoInvalidoException("El monto a transferir debe ser mayor a 0.");
        }
        //segundo, verificamos que la cuenta no esté vacía
        else if (this.cuentaDestino.isEmpty()) {
            throw new CuentaInvalidaException("Cuenta de destino no proporcionada.");
        }
        //tercero verificamos que el monto no exceda el limite permitido
        else if (this.monto >= 1000000){
            throw new LimiteSuperadoException("El monto excede la cantidad máxima permitida.");
        }
        //cuarto, verificamos que tiene saldo para realizar la operación.
        else if(this.saldo < this.monto){
            throw new SaldoException("El monto de transferencia excede el saldo de la cuenta.");
        } else {
            System.out.println("========================");
            System.out.println("Ejecutando operación...");
            System.out.println("Cuenta de destino: "+ cuentaDestino+"\nMonto de transferencia: "+monto);
        }
    }

}
public class OperacionBancaria {
    public static void main(String[] args) {

        TransferenciaBancaria trans1 = new TransferenciaBancaria(1000000,"928349823");
        TransferenciaBancaria trans2 = new TransferenciaBancaria(34783,"");
        TransferenciaBancaria trans3 = new TransferenciaBancaria(0,"23873223");

        ArrayList<TransferenciaBancaria> transferencias = new ArrayList<>();
        transferencias.add(trans1);
        transferencias.add(trans2);
        transferencias.add(trans3);
        for(TransferenciaBancaria tb : transferencias ){
            try{
                tb.ejecutarOperacion();
            } catch (LimiteSuperadoException | SaldoException | MontoInvalidoException | CuentaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
