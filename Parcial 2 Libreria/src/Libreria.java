import javax.swing.*;
import java.util.LinkedList;

public class Libreria {
    //
    private String nombre;
    private LinkedList<Libro> inventario = new LinkedList<Libro>();
    private LinkedList<Venta> ventas = new LinkedList<Venta>();

    public Libreria(String nombre) {
        this.nombre = nombre;
        this.inventario = inventario;
        this.ventas = ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Libro> getInventario() {
        return inventario;
    }

    public void setInventario(LinkedList<Libro> inventario) {
        this.inventario = inventario;
    }

    public LinkedList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(LinkedList<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "nombre='" + nombre + '\'' +
                ", inventario=" + inventario +
                ", ventas=" + ventas +
                '}';
    }

}
