package main.java.ejercicios;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Persona> list = new ArrayList<>();
        Persona persona = new Persona("María elena",25,'F');
        list.add(persona);
        Empleado empleado1 = new Empleado("Jesus", 25, 'M',"Chofer", 800000);
        list.add(empleado1);
        Empleado empleado2 = new Empleado("Aril", 21, 'M',"Recepcionista", 500000);
        list.add(empleado2);

        for (Persona sujeto : list ){
            System.out.println(sujeto.presentarse());
            if(sujeto instanceof Empleado emp){
                System.out.println("Si llego");
                System.out.println(
                        "Rol: "+emp.obtenerRol()+
                        "Salario despues de impuesto del 25%: "+emp.calcularSueldo()
                );
            }
        }
    }
}