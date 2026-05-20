package main.java.ejercicios.Exceptions;

public class SalarioException extends RuntimeException{
    public SalarioException(String mensaje){
        super(mensaje);
    }
}
