package co.edu.uniquindio.poo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CarritoCompras<T extends Producto> implements Iterable<T> {

    private ArrayList<T> listaProductos;

    public CarritoCompras() {
        listaProductos = new ArrayList<>();
    }

    public ArrayList<T> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<T> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void agregarProducto(T producto) {
        listaProductos.add(producto);
    }

    public T obtenerProductoMayorPrecio() {
        if (listaProductos.isEmpty()) {
            return null;
        }

        T productoMayor = listaProductos.get(0);
        for (int i = 1; i < listaProductos.size(); i++) {
            T productoActual = listaProductos.get(i);
            if (productoActual.getPrecio() > productoMayor.getPrecio()) {
                productoMayor = productoActual;
            }
        }
        return productoMayor;
    }

    public double calcularPrecioTotal() {
        double total = 0;
        for (int i = 0; i < listaProductos.size(); i++) {
            total = total + listaProductos.get(i).getPrecio();
        }
        return total;
    }

    @Override
    public Iterator<T> iterator() {
        return new CarritoIterator();
    }

    private class CarritoIterator implements Iterator<T> {

        private int indiceActual;

        public CarritoIterator() {
            indiceActual = 0;
        }

        @Override
        public boolean hasNext() {
            return indiceActual < listaProductos.size();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay mas productos en el carrito");
            }

            T producto = listaProductos.get(indiceActual);
            indiceActual++;
            return producto;
        }
    }
}