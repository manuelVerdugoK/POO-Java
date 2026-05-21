package main.java.ejercicios;
import java.util.ArrayList;
import java.time.LocalDate;

enum PrioridadTask{
    BAJA, MEDIA, ALTA
}

enum EventType{
    TASK, CALENDAR
}
interface Presentacion{
    String presentarEvento();
}

class Event implements Presentacion{
    private String nombre;
    private String descripcion;
    private EventType type;

    public Event(String nombre, String descripcion, EventType type) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.type = type;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public String presentarEvento(){
        return "nombre:"+nombre+"\ndescripcion:"+descripcion+"\ntipo evento:"+type;
    }
}

class Task extends Event{
    private PrioridadTask prioridad;

    public Task(String nombre, String descripcion, PrioridadTask prioridad) {
        super(nombre, descripcion, EventType.TASK);
        this.prioridad = prioridad;
    }

    public PrioridadTask getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadTask prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String presentarEvento(){
        return super.presentarEvento() + "\nprioridad:"+prioridad;
    }

}

class Calendar extends Event{
    private LocalDate fechaCalendario;

    public Calendar(String nombre, String descripcion, LocalDate fechaCalendario) {
        super(nombre, descripcion, EventType.CALENDAR);
        this.fechaCalendario = fechaCalendario;
    }

    public LocalDate getFecha() {
        return fechaCalendario;
    }

    public void setFecha(LocalDate fechaCalendario) {
        this.fechaCalendario = fechaCalendario;
    }

    @Override
    public String presentarEvento(){
        return super.presentarEvento()+ "\nfecha:"+ fechaCalendario;
    }
}

public class ToDoTask {
    public static void main(String[] args) {
        ArrayList<Event> listaEventos = new ArrayList<>();

        Calendar eventoCalendario1 = new Calendar(
                "Saludar hermana cumpleaños 27/05",
                "Recuerda llamar a tu hermana para saludarla por su cumpleaños",
                LocalDate.of(2026,5,27)
                );
        Calendar eventoCalendario2 = new Calendar(
                "Entrevista de trabajo ChileCompra",
                "A las 10:00am tendrás una entrevista técnica",
                LocalDate.of(2026,5,22)
        );

        Task eventoTarea1 = new Task(
                "Lavar la ropa",
                "Lavar la ropa de color negro, recordar usar suavisante.",
                PrioridadTask.BAJA
        );
        Task eventoTarea2 = new Task(
                "Ir a comprar comida para el gato",
                "recuerda que debe ser taste of the wild salmón",
                PrioridadTask.ALTA
        );

        listaEventos.add(eventoCalendario1);
        listaEventos.add(eventoCalendario2);
        listaEventos.add(eventoTarea1);
        listaEventos.add(eventoTarea2);

        System.out.println("======================================\n");
        for(Event evento : listaEventos){
            System.out.println("\n");
            System.out.println(evento.presentarEvento());
        }
    }
}
