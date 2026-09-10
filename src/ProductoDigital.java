public class ProductoDigital extends Producto{
    private int descuento;
    private String plataforma;

    ProductoDigital(String nombre, int precioBase, int stock, int descuento, String plataforma){
        super(nombre, precioBase, stock);
        this.descuento = descuento;
        this.plataforma = plataforma;
    }
    public int getDescuento() {
        return this.descuento;
    }
    public String getPlataforma() {
        return this.plataforma;
    }
    @Override
    public int calcularPrecioFinal() {
        return this.getPrecioBase() - (this.getPrecioBase() * this.descuento)/100;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " descuento de " + this.descuento +"%" + "[PLATAFORMA] " + this.plataforma;
    }
}
