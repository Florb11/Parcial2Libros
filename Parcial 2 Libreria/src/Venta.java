public class Venta {
    private String tituloLibro;
    private int cantidad;
    private double precioTotal;

    public Venta(String tituloLibro, int cantidad, double precioTotal) {
        this.tituloLibro = tituloLibro;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "tituloLibro='" + tituloLibro + '\'' +
                ", cantidad=" + cantidad +
                ", precioTotal=" + precioTotal +
                '}';
    }
}

