
package mundo;


public class ProductoConDescuento extends ProductoDecorador{
    
   private int descuento;

    public ProductoConDescuento(Producto producto, int descuento) {
        super(producto);
        this.descuento = descuento;
    }

    @Override
    public int getPrecio() {
        return producto.getPrecio() - descuento;
    }

    @Override
    public String getNombre() {
        return this.producto.getNombre() + " (Descuento de " + descuento + ")";
    } 
    
}
