import javax.swing.*;

public class Cliente extends Usuario {
    //Atributos
    private Libreria libreria;
    private int cantidadLibrosComprados;

    //Constructor

    public Cliente(String nombre, String contrasenia, Libreria libreria) {
        super(nombre, contrasenia);
        this.cantidadLibrosComprados = 0; // lo inicio en 0 porque no compro todavia
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
    public boolean iniciarSesion(String nombre, String contrasenia) {
        if (!this.getNombre().equals(nombre) || !this.getContrasenia().equals(contrasenia)) {
            JOptionPane.showMessageDialog(null, "Usuario invalido, vuelva a intentar");
            return false;
        }
        ImageIcon Icon = new ImageIcon("src/img/cliente.png");

        String[] opciones = {"Ver libros", "Comprar libro", "Ver mis compras", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opcion:",
                    "Menu de Cliente",
                    0,
                    0,
                    Icon,
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
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
            }

        } while (opcion != 3);

        return true;
    }

    public void verLibrosDisponibles(Libreria libreria) {
        if (libreria.getInventario().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros disponibles");
            return;
        }

        String mensaje = "Libros disponibles:\n";
        for (Libro libro : libreria.getInventario()) {
            mensaje += libro + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void comprarLibro(Libreria libreria) {
        String titulo = validarCaracteres("Ingrese el titulo del libro que desea comprar");
        Libro libroEncontrado = null;

        for (Libro libro : libreria.getInventario()) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libroEncontrado = libro;
                break;
            }
        }

        if (libroEncontrado != null) {
            int cantidad = validarNumeros(JOptionPane.showInputDialog("Ingrese la cantidad que desea comprar"));
            if (libroEncontrado.getStock() >= cantidad) {
                libroEncontrado.setStock(libroEncontrado.getStock() - cantidad);
                this.cantidadLibrosComprados += cantidad;

                Venta nuevaVenta = new Venta(libroEncontrado.getTitulo(), cantidad, libroEncontrado.getPrecio() * cantidad);
                libreria.getVentas().add(nuevaVenta);

                JOptionPane.showMessageDialog(null, "Compra realizada con exito:\n" + "Titulo: " + libroEncontrado.getTitulo() + "\n" + "Cantidad comprada: " + cantidad);
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficiente stock\n" +
                        "Stock disponible: " + libroEncontrado.getStock());
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro el libro con el título: " + titulo);
        }
    }

    public void verLibrosComprados() {
        if (this.cantidadLibrosComprados == 0) {
            JOptionPane.showMessageDialog(null, "No ha comprado ningun libro todavia.");
        } else {
            JOptionPane.showMessageDialog(null, "Ha comprado un total de " + this.cantidadLibrosComprados + " libros");
        }
    }

    public String validarCaracteres(String mensaje) {
        String palabra = "";
        while (palabra.equals("")) {
            palabra = JOptionPane.showInputDialog(mensaje);
        }
        return palabra;
    }

    public int validarNumeros(String mensaje) {
        boolean flag;
        String valida;
        do {
            flag = true;
            valida = JOptionPane.showInputDialog(mensaje);
            while (valida.isEmpty()) {
                valida = JOptionPane.showInputDialog("Error: " + mensaje);
            }
            for (int i = 0; i < valida.length(); i++) {
                if (!Character.isDigit(valida.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Solo se permiten numeros.");
                    flag = false;
                    break;
                }
            }
        } while (!flag);

        return Integer.parseInt(valida);
    }
}


