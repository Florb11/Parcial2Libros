import java.util.LinkedList;

public class Inventario {
    //Atributos
    private LinkedList<Libro> librosLista= new LinkedList<Libro>();

    //Constructor

    public Inventario() {
        this.librosLista = librosLista;

    }

    //Get y set


    public LinkedList<Libro> getLibrosLista() {
        return librosLista;
    }

    public void setLibrosLista(LinkedList<Libro> librosLista) {
        this.librosLista = librosLista;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "librosLista=" + librosLista +
                '}';
    }
}
