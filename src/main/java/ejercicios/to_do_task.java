package main.java.ejercicios;



enum prioridadTask{
    BAJA, MEDIA, ALTA
}

enum eventType{
    TASK, CALENDAR
}

class Event{
    private String nombre;
    private String descripcion;
    private eventType type;

    public Event(String nombre, String descripcion, eventType type) {
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

    public eventType getType() {
        return type;
    }

    public void setType(eventType type) {
        this.type = type;
    }
}

class Task extends Event{
    private prioridadTask prioridad;

    public Task(String nombre, String descripcion, prioridadTask prioridad) {
        super(nombre, descripcion, eventType.TASK);
        this.prioridad = prioridad;
    }

    public prioridadTask getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(prioridadTask prioridad) {
        this.prioridad = prioridad;
    }

}

public class to_do_task {
    public static void main(String[] args) {


    }
}
