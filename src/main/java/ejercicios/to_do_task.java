package main.java.ejercicios;


import java.util.Date;

enum prioridadTask{
    BAJA, MEDIA, ALTA
}

enum eventType{
    TASK, CALENDAR
}
interface presentacion{
    String presentarEvento();
}

class Event implements presentacion{
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

    public String presentarEvento(){
        return "nombre:"+nombre+"\ndescripcion:"+descripcion+"\ntipo evento:"+type;
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

    @Override
    public String presentarEvento(){
        return presentarEvento() + "prioridad:"+prioridad;
    }

}

class Calendar extends Event{
    private Date Fecha;

    public Calendar(String nombre, String descripcion, Date fecha) {
        super(nombre, descripcion, eventType.CALENDAR);
        Fecha = fecha;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    @Override
    public String presentarEvento(){
        return presentarEvento() + "fecha:"+fecha;
    }
}

public class to_do_task {
    public static void main(String[] args) {


    }
}
