package main.java.ejercicios;
import main.java.ejercicios.Exceptions.RolException;
import main.java.ejercicios.Exceptions.SalarioException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Empleado emp = new Empleado("Eddy", 25,'M', "", 100 );
        try {
            System.out.println(emp.calcularSueldo());
            System.out.println(emp.obtenerRol());
        } catch (SalarioException | RolException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}