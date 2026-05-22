package main.java.ejercicios;
import java.util.ArrayList;
import java.util.Optional;
class PrestamoNoEncontado extends RuntimeException{
    public PrestamoNoEncontado(String mensaje){ super(mensaje);}
}
enum TipoRegistro{
    prestado, entregado
}
enum EstadoPrestamo{
    entregado, prestado
}
class Libro{
    private int id_libro;
    private String titulo;
    private String autor;
    private int ano;
    private int stock;
    private int cantidad_prestados;

    public Libro(int id, String titulo, String autor, int ano, int cantidad) {
        this.id_libro = id;this.titulo = titulo;this.autor = autor;
        this.ano = ano;this.stock = cantidad;this.cantidad_prestados=0;
    }

    public int getId() {return id_libro;}
    public int getCantidad_prestados() {return cantidad_prestados;}
    public void incrementarPrestamos() {this.cantidad_prestados = this.cantidad_prestados+1;}
    public void decrementarPrestamos() {this.cantidad_prestados = this.cantidad_prestados-1;}
    public String getTitulo(){return this.titulo;}

    public boolean consultarDisponiblidad(){return this.stock>this.cantidad_prestados;}
}

class Prestamo{
    private int id_prestamo;
    private Libro libro;
    private EstadoPrestamo estado;

    public Prestamo(int id, Libro libro) {
        this.id_prestamo = id;
        this.libro = libro;

    }
    public void setEstadoPrestamoEntregado(){
        this.estado = EstadoPrestamo.entregado;
    }
    public void setEstadoPrestamoPrestado(){
        this.estado = EstadoPrestamo.prestado;
    }
    private void decrementarPrestamo(){libro.decrementarPrestamos();}
    private void incrementarPrestamo(){libro.incrementarPrestamos();}
    public int getId(){return this.id_prestamo;}
    public void prestarLibro(){
        setEstadoPrestamoPrestado();
        incrementarPrestamo();
    }
    public void devolverLibro(){
        setEstadoPrestamoEntregado();
        decrementarPrestamo();
    }
    public String presentarPrestamo(){
        return "\nid: "+this.id_prestamo+"\nlibro: "+this.libro.getTitulo()+"\nestado: "+this.estado;
    }

}

class RegistroPrestamosLibro{
    private int acumId;
    private TipoRegistro tipoRegistro;
    private ArrayList<Prestamo> registro;

    public RegistroPrestamosLibro(TipoRegistro tipoRegistro) {

        this.acumId=0;
        this.tipoRegistro=tipoRegistro;
        this.registro = new ArrayList<>();
    }
    public int getAcumId(){return this.acumId;}
    public void setAcumId(){this.acumId = this.acumId+1;}
    public void setTipoRegistro(){this.tipoRegistro = TipoRegistro.entregado;}
    public void generarRegistro(Libro libro){
        if (libro.consultarDisponiblidad()){
            Prestamo nuevoPrestamo = new Prestamo(getAcumId()+1,libro);
            nuevoPrestamo.prestarLibro();
            registro.add(nuevoPrestamo);
            setAcumId();
        } else{
            System.out.println("El libro consultado se encuentra agotado.");
        }
    }
    public void devolverLibro(int id){
        try{
            Optional<Prestamo> instance = buscarPrestamo(id);
            instance.get().devolverLibro();
            setTipoRegistro();
        } catch (PrestamoNoEncontado e){
            System.out.println(e.getMessage());
        }
    }
    public Optional<Prestamo> buscarPrestamo(int id){
        Optional<Prestamo> prestamoEncontrado = this.registro.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
        if (!(prestamoEncontrado.isEmpty())){
            return prestamoEncontrado;
        } else{
            throw new PrestamoNoEncontado("No se encontró ningún prestamo");
        }

    }
    public void imprimirRegistros(){
        for(Prestamo x : registro){
            System.out.println( x.presentarPrestamo());
        }
    }
    public void imprimirRegistroUnico(int id){
        try{
            Optional<Prestamo> instance = buscarPrestamo(id);
            System.out.println(" === PRESTAMO ===");
            System.out.println(instance.get().presentarPrestamo());
        } catch (PrestamoNoEncontado e) {
            System.out.println(e.getMessage());
        }


    }
}
public class SistemaBiblioteca {
    public static void main(String[] args) {
        Libro libro = new Libro(123,"El quijote de la mancha","Alguien",2000,5);
        RegistroPrestamosLibro rgPrestamo = new RegistroPrestamosLibro(TipoRegistro.prestado);
        rgPrestamo.generarRegistro(libro);



        rgPrestamo.imprimirRegistroUnico(1);
        rgPrestamo.devolverLibro(1);
        rgPrestamo.imprimirRegistroUnico(1);

    }
}
