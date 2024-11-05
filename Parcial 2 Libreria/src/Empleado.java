import javax.swing.*;
public class Empleado extends Usuario {
    private String cargo;
    private Libreria libreria;

    public Empleado(String nombre, String contrasenia, String cargo, Libreria libreria) {
        super(nombre, contrasenia);
        this.cargo = cargo;
        this.libreria = libreria;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Libreria getLibreria() {
        return libreria;
    }

    public void setLibreria(Libreria libreria) {
        this.libreria = libreria;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "cargo='" + cargo + '\'' +
                ", libreria=" + libreria +
                "} " + super.toString();
    }

    @Override
    public boolean iniciarSesion(String nombre, String contrasenia) {
        if (!this.getNombre().equals(nombre) || !this.getContrasenia().equals(contrasenia)) {
            JOptionPane.showMessageDialog(null, "Usuario invalido, vuelva a intentar");
            return false;
        }
        ImageIcon Icon = new ImageIcon("src/img/empleado.png");

        String[] opciones = {"Agregar libro", "Eliminar libro", "Buscar libro", "Realizar venta", "Salir"};
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null,
                    "Seleccione una opcion:",
                    "Menu de Empleado",
                    0,
                    0,
                    Icon,
                    opciones,
                    opciones[0]);

            switch (opcion) {
                case 0:
                    agregarLibro();
                    break;
                case 1:
                    eliminarLibro();
                    break;
                case 2:
                    buscarLibro();
                    break;
                case 3:
                    realizarVenta();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo....");
                    break;
            }
        } while (opcion != 4);

        return true;
    }

    public void agregarLibro() {
        String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro a agregar");
        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro");
        int cantidad = validarNumeros("Ingrese la cantidad a agregar");
        Libro nuevo = new Libro(titulo, autor, 100.0, cantidad); // le dejo el 100 para probar acordarme

        for (Libro item : libreria.getInventario()) {
            if (item.getTitulo().equals(nuevo.getTitulo())) {
                item.setStock(item.getStock() + nuevo.getStock());
                JOptionPane.showMessageDialog(null, "Cantidad actualizada del libro: " + titulo);
                return;
            }
        }
        libreria.getInventario().add(nuevo);
        JOptionPane.showMessageDialog(null, "Libro agregado con exito: " + titulo);
    }

    public void eliminarLibro() {
        String titulo = validarNombre("Ingrese el titulo del libro a eliminar");

        for (Libro item : libreria.getInventario()) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                libreria.getInventario().remove(item);
                JOptionPane.showMessageDialog(null, "Libro eliminado: " + titulo);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro el libro: " + titulo);
    }

    public Libro buscarLibro() {
        String criterio = validarNombre("Ingrese el titulo del libro a buscar");
        if (libreria.getInventario().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista de libros esta vacia.");
            return null;
        }
        for (Libro libro : libreria.getInventario()) {
            if (libro.getTitulo().equalsIgnoreCase(criterio)) {
                JOptionPane.showMessageDialog(null, "Libro encontrado:\n" + libro);
                return libro;
            }
        }
        JOptionPane.showMessageDialog(null, "No se encontro el libro con el titulo: " + criterio);
        return null;
    }

    public void realizarVenta() {
        String titulo = validarNombre("Ingrese el titulo del libro a vender");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a vender"));

        Libro libroEncontrado = buscarLibro();

        if (libroEncontrado != null) {
            if (libroEncontrado.getStock() >= cantidad) {
                libroEncontrado.setStock(libroEncontrado.getStock() - cantidad);
                double precioTotal = libroEncontrado.getPrecio() * cantidad;
                Venta venta = new Venta(libroEncontrado.getTitulo(), cantidad, precioTotal);
                libreria.getVentas().add(venta);

                JOptionPane.showMessageDialog(null, "Venta realizada con exito!!\n" +
                        "Título: " + libroEncontrado.getTitulo() + "\n" + "Cantidad vendida: " + cantidad + "\n" + "Nuevo stock: " + libroEncontrado.getStock() + "\n" + "Precio total: " + precioTotal);
            } else {
                JOptionPane.showMessageDialog(null, "No hay suficiente stock para realizar la venta\n" + "Stock disponible: " + libroEncontrado.getStock());
            }
        } else {
            JOptionPane.showMessageDialog(null, "El libro no se encontro");
        }
    }
    public String validarNombre(String mensaje) {
        boolean flag;
        String validar;

        do {
            flag = true;
            validar = JOptionPane.showInputDialog(null, mensaje);
            while (validar.isEmpty()) {
                validar = JOptionPane.showInputDialog(null, "Error. " + mensaje);
            }
            for (int i = 0; i < validar.length(); i++) {
                if (!Character.isAlphabetic(validar.charAt(i))) {
                    JOptionPane.showMessageDialog(null, "Ingresa el nombre, sin numeros");
                    flag = false;
                    break;
                }
            }
        } while (!flag);
        return validar;
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

