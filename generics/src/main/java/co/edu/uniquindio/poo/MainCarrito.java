package co.edu.uniquindio.poo;

import java.util.Scanner;

public class MainCarrito {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        CarritoCompras<Producto> carrito = new CarritoCompras<>();
        String respuesta;

        do {
            System.out.println("\n--- Agregar producto al carrito ---");

            System.out.print("Nombre del producto: ");
            String nombre = teclado.nextLine();

            System.out.print("Precio del producto: ");
            double precio = Double.parseDouble(teclado.nextLine());

            Producto producto = new Producto(nombre, precio);
            carrito.agregarProducto(producto);

            System.out.println("Producto agregado: " + producto);

            System.out.print("¿Desea agregar otro producto al carrito? (s/n): ");
            respuesta = teclado.nextLine();

        } while (respuesta.equalsIgnoreCase("s"));

        System.out.println("\n--- Resumen del carrito ---");
        System.out.println("Productos en el carrito: " + carrito.getListaProductos());

        Producto masCaro = carrito.obtenerProductoMayorPrecio();
        System.out.println("Producto de mayor precio: " + masCaro);

        double total = carrito.calcularPrecioTotal();
        System.out.println("Precio total del carrito: " + total);

        System.out.println("\nRecorrido con el iterador: ");
        for (Producto p : carrito) {
            System.out.println("Producto: " + p);
        }

        teclado.close();
    }
}