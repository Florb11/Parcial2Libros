import javax.swing.*;

public class Cliente extends Usuario {
    //Atributos
    private Libreria libreria;
    private int cantidadLibrosComprados;

    //Constructor

    public Cliente(String nombre, String contrasenia, Libreria libreria) {
        super(nombre, contrasenia);
        this.cantidadLibrosComprados = 0;
        this.libreria = libreria;
    }
    //get y set


    public Libreria getLibreria() {
        return libreria;
    }

    public void setLibreria(Libreria libreria) {
        this.libreria = libreria;
    }

    public int getcantidadLibrosComprados() {
        return cantidadLibrosComprados;
    }

    public void setcantidadLibrosComprados(int cantidadLibrosComprados) {
        this.cantidadLibrosComprados = cantidadLibrosComprados;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "libreria=" + libreria +
                ", cantidadLibrosComprados=" + cantidadLibrosComprados +
                "} " + super.toString();
    }

    @Override
    public boolean iniciarSesion(String nombre, String contraseña) {
        if (!this.getNombre().equals(nombre) || !this.getContrasenia().equals(contraseña)) {
            JOptionPane.showMessageDialog(null, "Usuario invalido, vuelva a intentar");
            return false;
        }

        String[] opciones = {"Ver libros", "Comprar libro", "Ver mis compras", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opcion:",
                    "Menú de Cliente",
                    0,
                    0,
                    null,
                    opciones,
                    opciones[0]);

            switch (opcion) {
                case 0:
                    verLibrosDisponibles(libreria);
                    break;
                case 1:
                    comprarLibro(libreria);
                    break;
                case 2:
                    verLibrosComprados();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 3);

        return true;
    }
    public void verLibrosDisponibles(Libreria libreria) {
        if (libreria.getInventario().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros disponibles en la librería.");
            return;
        }

        String mensaje = "Libros disponibles:\n";
        for (Libro libro : libreria.getInventario()) {
            mensaje += libro.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public void comprarLibro(Libreria libreria) {
        String titulo = JOptionPane.showInputDialog("Ingrese el título del libro que desea comprar");
        Libro libroEncontrado = null;

        for (Libro libro : libreria.getInventario()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libroEncontrado = libro;
                break;
            }
        }

        if (libroEncontrado != null) {
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad que desea comprar"));
            if (libroEncontrado.getStock() >= cantidad) {
                libroEncontrado.setStock(libroEncontrado.getStock() - cantidad);
                cantidadLibrosComprados += cantidad; // Incrementamos el contador
                JOptionPane.showMessageDialog(null, "Compra realizada con éxito:\n" +
                        "Título: " + libroEncontrado.getTitulo() + "\n" +
                        "Cantidad comprada: " + cantidad);
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficiente stock para realizar la compra.\n" +
                        "Stock disponible: " + libroEncontrado.getStock());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el libro con el título: " + titulo);
        }
    }

    public void verLibrosComprados() {
        if (cantidadLibrosComprados == 0) {
            JOptionPane.showMessageDialog(null, "No ha comprado ningún libro todavía.");
        } else {
            JOptionPane.showMessageDialog(null, "Ha comprado un total de " + cantidadLibrosComprados + " libros.");
        }
    }
}



