import javax.swing.*;
public class Estadistica {
    private Libreria libreria;

    public Estadistica(Libreria libreria) {
        this.libreria = libreria;
    }

    public double calcularTotalVentas() {
        double total = 0;
        for (Venta venta : libreria.getVentas()) {
            total += venta.getPrecioTotal();
        }
        return total;
    }

    public int calcularCantidadLibrosVendidos() {
        int totalLibrosVendidos = 0;
        for (Venta venta : libreria.getVentas()) {
            totalLibrosVendidos += venta.getCantidad();
        }
        return totalLibrosVendidos;
    }


    public int calcularInventarioTotal() {
        int totalInventario = 0;
        for (Libro libro : libreria.getInventario()) {
            totalInventario += libro.getStock();
        }
        return totalInventario;
    }
    public void mostrarEstadisticas() {
        JOptionPane.showMessageDialog(null, "Total de Ventas: " + calcularTotalVentas());
        JOptionPane.showMessageDialog(null, "Cantidad Total de Libros Vendidos: " + calcularCantidadLibrosVendidos());
        JOptionPane.showMessageDialog(null, "Total de Libros en Inventario: " + calcularInventarioTotal());
    }
}
