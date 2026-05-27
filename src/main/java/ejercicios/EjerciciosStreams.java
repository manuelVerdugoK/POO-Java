package main.java.ejercicios;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.round;


public class EjerciciosStreams {

    static class Producto {
        String nombre;
        double precio;

        public Producto(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
        public String presentarse(){
            return String.format("Nombre: %s || Precio: %s", nombre, round(precio));
        }
        public Producto subirPrecio(double porcentaje) {
            return new Producto(this.nombre, this.precio * porcentaje);
        }
    }
    public static void main(String[] args) {
        List<String> nombres = List.of(
                "Ana", "Bruno", "Carla", "iza", "Diego", "Elena", "Felipe"
        );
        // for normal
        // el indice i inicializa en 0,
        // el indice se compara con una expresión o variable del mismo tipo.
        // el indice se acumula.
        for (String s : nombres) {
            System.out.println(s);
        }

        // solo mayor que 4 letras.
        for (String nombre : nombres){
            if(nombre.length()>3){
                System.out.println(nombre);
            }
        }
        System.out.println("===================== separador stream + filter + foreach ===================== ");

        // un stream es una copia temporal sobre un elemento
        // permite operar sobre él sin modificar su origen.
        // devuelve algo nuevo.
        nombres.stream()
                .filter(item -> item.length()>3)
                .forEach(System.out::println);

        System.out.println("===================== stream + map + for each ===================== ");
        // map transforma el elemento entrante en algo más, ej: un objeto transformado a solo un atributo del mismo.
        nombres.stream().map(String::toUpperCase).forEach(System.out::println);


        System.out.println("===================== stream + map + generar nueva lista inmutable ===================== ");

        List<String> nombresMayuscula = nombres.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(nombresMayuscula);


        System.out.println("===================== stream + map + generar nueva lista mutable ===================== ");

        List<String> nombresMayusculaCollector = nombres.stream()
                .filter(item -> item.length()>3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        nombresMayusculaCollector.add("BRAULIO");
        System.out.println(nombresMayusculaCollector);

        System.out.println("===================== separador ===================== ");


        List<Producto> productos = List.of(
                new Producto("Leche", 1200),
                new Producto("Pan", 850),
                new Producto("Café", 3200),
                new Producto("Azúcar", 950),
                new Producto("Chocolate", 2800)
        );

        productos.stream()
                .filter(item -> item.precio>1000)
                .forEach(item -> System.out.println(item.nombre));
        System.out.println("===================== separador ===================== ");
        List<String> nombreProductos = productos.stream()
                .filter(item -> item.precio>1000)
                .map(item-> item.nombre)
                .collect(Collectors.toList());
        System.out.println(nombreProductos);
        System.out.println("===================== separador ===================== ");

        double sumaCortaLarga = productos.stream()
                .map(item-> item.precio)
                .reduce(0.0, (a, b) -> Double.sum(a, b));
        //0.0 es el acumulador
        // a hace referencia al acumulador, es la primera posicion
        // b hace referencia al elemento entrante (item.precio) y se envuelve en parentesis como una lambda
        // la lambda dice que sumen dos double.

        double sumaCorta = productos.stream()
                .map(item-> item.precio)
                .reduce(0.0, Double::sum);
        System.out.println(sumaCorta);

        System.out.println("===================== Ejercicio libre 1 ===================== ");
        // incrementar en 15% el valor de los productos.
        productos.forEach(item -> System.out.println(item.presentarse()));
        System.out.println("-- separacion --");
        List<Producto> nuevaListaPrecioProductos = productos.stream()
                .map(producto -> producto.subirPrecio(1.15))
                .collect(Collectors.toList());
        nuevaListaPrecioProductos.forEach(item -> System.out.println(item.presentarse()));


        System.out.println("===================== Ejercicio libre 2 ===================== ");
        // buscar productos que no contengan la letra 'e' y que su precio sea mayor a 1000.
        List<Producto> busquedaEncadenada = productos.stream()
                .filter(product -> !product.nombre.contains("e"))
                .filter(product -> product.precio>1000)
                .toList();
        // se retorna intencionalmente una lista inmutable
        busquedaEncadenada.forEach(i->System.out.println(i.presentarse()));
    }
}