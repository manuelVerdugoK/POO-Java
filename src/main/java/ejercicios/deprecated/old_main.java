package main.java.ejercicios.deprecated;

import java.util.HashMap;
import java.util.HashSet;

public class old_main {
    public static void main(String[] args) {
        Empleado emp = new Empleado("Eddy", 25,'M', "Médico", 100 );
        try {
            System.out.println(emp.calcularSueldo());
            System.out.println(emp.obtenerRol());
        } catch (SalarioException | RolException e) {
            System.out.println("Error: " + e.getMessage());
        }

        HashMap<String, Persona> diccionarioPersonas = new HashMap<>();
        diccionarioPersonas.put("Eddy", emp);

        Persona per = new Persona("María", 20, 'F');
        diccionarioPersonas.put("María",per);

        Persona per2 = new Persona("José", 33, 'M');
        diccionarioPersonas.put("José", per2);


        for(String i: diccionarioPersonas.keySet()){
            System.out.println(
                    diccionarioPersonas.get(i).presentarse());
        }
        System.out.println("\n");
        String buscar = "Pedro";
        if (diccionarioPersonas.containsKey(buscar)){
            System.out.println(diccionarioPersonas.get(buscar).presentarse());
        }else{
            System.out.println("Persona no encontrada: "+buscar);
        }


        HashSet<Persona> set = new HashSet<>();
        Persona np = new Persona("Andrea",29,'F');
        Persona np2 = new Persona("Camila",29,'F');
        Persona np3 = new Persona("Camila",29,'F');
        set.add(np);
        set.add(np2);
        set.add(np3);

        for(Persona elem : set){
            System.out.println(elem.presentarse());
        }
    }
}
