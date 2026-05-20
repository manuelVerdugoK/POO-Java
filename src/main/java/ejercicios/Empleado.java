package main.java.ejercicios;

public class Empleado extends Persona implements Trabajador {
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
    public double calcularSueldo(){
        double impuesto = 0.25;
        return (getSalario() - (getSalario()*impuesto));
    }
    @Override
    public String obtenerRol(){
        return "Rol:"+getCargo();
    }
}
