import javax.swing.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria("pepe");
        Cliente cliente1 = new Cliente("Juan", "1234",libreria);
        Empleado empleado1 = new Empleado("Lucia", "abcd", "Empleado de ventas",libreria);
        Estadistica estadistica = new Estadistica(libreria);


        String[] menu = { "Iniciar sesion como Empleado", "Iniciar sesion como Cliente","Mostrar estadisticas", "Salir" };
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Libreria",
                    "Menu Usuarios",
                   0,
                    0,
                    null,
                    menu,
                    menu[0]);

            switch (opcion) {
                case 0:
                    empleado1.iniciarSesion("Lucia", "abcd");
                    break;

                case 1:
                    cliente1.iniciarSesion("fdfsd","1234");
                case 2:
                    estadistica.mostrarEstadisticas();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
            }
        } while (opcion != 3);
    }
}

