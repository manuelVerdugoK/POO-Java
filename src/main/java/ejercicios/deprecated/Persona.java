// ejercicios/Persona.java
package main.java.ejercicios.deprecated;

import java.util.Objects;

public class Persona {
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
