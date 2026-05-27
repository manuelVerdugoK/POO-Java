package main.java.ejercicios;
enum TipoAnimal{
    GATO, PERRO
}
interface Ianimal{
    void dormirRoncando();
}
interface Igato{
    void maullar();
    void ronronear();
    void ignorar();
}
interface Iperro{
    void ladrar();
    void emocionarse();
}
abstract class Animal implements Ianimal {
    private TipoAnimal tipo;
    private String nombre;
    private int edad;

    public Animal(TipoAnimal tipo, String nombre, int edad) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.edad = edad;
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
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

    public abstract void dormir();
}

class Gato extends Animal implements Igato{
    public Gato(String nombre, int edad){super(TipoAnimal.GATO, nombre,edad);}
    public void maullar(){System.out.println("Gato dice: Meow");}
    public void ronronear(){System.out.println("Gato dice: prrrrr prrrrr prrrr ...");}
    public void ignorar(){System.out.println("...");}
    public void dormir(){System.out.println("Gato está dormido");}
    public void dormirRoncando(){System.out.println("Gato está durmiendo y roncando");}
}

class Perro extends Animal implements Iperro {
    public Perro(String nombre, int edad) {super(TipoAnimal.PERRO, nombre, edad);}

    public void ladrar() {
        int minimo = 1;
        int maximo = 5;
        int numero = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
        for (int i = 0; i < numero; i++) {
            System.out.println("Perro dice: woff");
        }
    }
    public void emocionarse() {
        int minimo = 5;
        int maximo = 15;
        int numero = (int) (Math.random() * (maximo - minimo + 1)) + minimo;
        for (int i = 0; i < numero; i++) {
            System.out.println("Perro dice: woff mientras mueve la cola...");
        }
    }
    public void dormir(){System.out.println("Perro está dormido");}
    public void dormirRoncando(){System.out.println("Perro está durmiendo y roncando");}

}
public class Animales{
    public static void main(String[] args) {
        Gato gato = new Gato("Mike", 3);
        Perro perro = new Perro("Doggy",7);
        gato.maullar();
        perro.ladrar();
        Animal animal_perro =  new Perro("Doggy",7);
        Animal animal_gato= new Gato("Mike", 3);
        animal_perro.dormir();
        animal_gato.dormir();
    }
}

