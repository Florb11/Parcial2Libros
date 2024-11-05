import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Libreria libreria = new Libreria("pepe");
        Cliente cliente1 = new Cliente("Juan", "1234",libreria);
        Empleado empleado1 = new Empleado("Lucia", "abcd", "Empleado mutifuncion",libreria);
        Estadistica estadistica = new Estadistica(libreria);
        ImageIcon Icon = new ImageIcon("src/img/menu.png");


        String[] menu = { "Iniciar sesion como Empleado", "Iniciar sesion como Cliente","Mostrar estadisticas", "Salir" };
        int opcion;

        do {
            opcion = JOptionPane.showOptionDialog(null, "Libreria",
                    "Menu Usuarios",
                   0,
                    0,
                    Icon,
                    menu,
                    menu[0]);

            switch (opcion) {
                case 0:
                    empleado1.iniciarSesion("Lucia", "abcd");
                    break;

                case 1:
                    cliente1.iniciarSesion("Juan","1234");
                    break;
                case 2:
                    estadistica.mostrarEstadisticas();
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Saliendo.....");
                    break;
            }
        } while (opcion != 3);
    }
}

