package main.java.ejercicios;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
interface Trabajador {
    double calcularSueldo();
    String obtenerRol();
}
class SalarioException extends RuntimeException{
    public SalarioException(String mensaje){
        super(mensaje);
    }
}

class RolException extends RuntimeException{
    public RolException(String mensaje){
        super(mensaje);
    }
}
class Persona {
    private String nombre;
    private int edad;
    private char sexo;

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", sexo=" + sexo +
                '}';
    }

    @Override
    public boolean equals(Object x){
        if(this == x) return true;
        if (!(x instanceof Persona)) return false;
        Persona per = (Persona) x;
        return edad == per.edad && nombre.equals(per.nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre, edad);
    }

    public String presentarse(){
        if ( sexo == 'M' ){
            return String.format("Mucho gusto, mi nombre es %s, y soy un hombre de %s años.",nombre, edad);
        } else if (sexo == 'F') {
            return String.format("Mucho gusto, mi nombre es %s, y soy una mujer de %s años.",nombre, edad);
        } else{
            return "Sexo invalido";
        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}

class Empleado extends Persona implements Trabajador {
    private String cargo;
    private double salario;

    public Empleado(String nombre, int edad, char sexo, String cargo, double salario) {
        super(nombre, edad, sexo);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String presentarse(){
        if ( getSexo() == 'M' ){
            return String.format("Mucho gusto, mi nombre es %s, y soy un hombre de %s años y me dedico a %s",getNombre(), getEdad(), cargo);
        } else if ( getSexo() == 'F') {
            return String.format("Mucho gusto, mi nombre es %s, y soy una mujer de %s años y me dedico a %s",getNombre(), getEdad(), cargo);
        } else{
            return "Sexo invalido";
        }

    }

    @Override
    public double calcularSueldo() {
        if (getSalario() < 1) {
            throw new SalarioException("El salario está fuera de rango.");
        }
        double impuesto = 0.25;
        return getSalario() - (getSalario() * impuesto);
    }

    @Override
    public String obtenerRol(){
        if (getCargo().length() < 1){
            throw new RolException("El cargo está fuera de rango.");
        }
        return "Rol:"+getCargo();
    }
}


public class PersonasEmpleados {
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
