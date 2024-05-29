
package mundo;


abstract class ProductoDecorador implements Producto {
    protected Producto producto;

    public ProductoDecorador(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String getNombre() {
        return producto.getNombre();
    }

    @Override
    public int getPrecio() {
        return producto.getPrecio();
    }
}
