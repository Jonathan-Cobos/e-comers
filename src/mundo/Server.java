
package mundo;

import java.util.ArrayList;
import java.util.List;


public class Server implements Sujeto{
   
    private Categoria[] categorias;
    private List<Observador> observadores;
    
    public Server() {
        categorias = new Categoria[4];
        categorias[0] = new Categoria("electrodomesticos");
        categorias[1] = new Categoria("aseo");
        categorias[2] = new Categoria("papeleria");
        categorias[3] = new Categoria("otros");      
        observadores = new ArrayList<>();
        
    }

    public Productos obtenerProducto(String categoria,String nombre){
        if (categoria.equals(categorias[0].getNombre()) ) {
            return categorias[0].obtenerProducto(nombre);
        }
       if (categoria.equals(categorias[1].getNombre()) ) {
            return categorias[1].obtenerProducto(nombre);
        }
       if (categoria.equals(categorias[2].getNombre()) ) {
            return categorias[2].obtenerProducto(nombre);
        }
       if (categoria.equals(categorias[3].getNombre()) ) {
            return categorias[3].obtenerProducto(nombre);
        }
        return null;
    }
    
    public Categoria[] getCategorias() {
        return categorias;
    }

    public void setCategorias(Categoria[] categorias) {
        this.categorias = categorias;
    }
    
    public void publicarProducto(Productos prod){
        
        String categoria = prod.getCategoria();
        if (categoria.equals(categorias[0].getNombre()) ) {
            categorias[0].guardarProducto(prod);
        }
       if (categoria.equals(categorias[1].getNombre()) ) {
            categorias[1].guardarProducto(prod);
        }
       if (categoria.equals(categorias[2].getNombre()) ) {
            categorias[2].guardarProducto(prod);
        }
       if (categoria.equals(categorias[3].getNombre()) ) {
            categorias[3].guardarProducto(prod);
        }
       notificarObservadores("Producto publicado: " + prod.getNombre());
    }
    
    public void consultarProductos(String categoria){
        
        if (categoria.equals(categorias[0].getNombre()) ) {
           categorias[0].imprimirArreglo();
        }
       if (categoria.equals(categorias[1].getNombre()) ) {
            categorias[1].imprimirArreglo();
        }
       if (categoria.equals(categorias[2].getNombre()) ) {
            categorias[2].imprimirArreglo();
        }
       if (categoria.equals(categorias[3].getNombre()) ) {
            categorias[3].imprimirArreglo();
        }       
        
    }
    
    public void venderProducto(Productos prod){
        
        String categoria = prod.getCategoria();
        if (categoria.equals(categorias[0].getNombre()) ) {
            categorias[0].eliminarProducto(prod);
        }
       if (categoria.equals(categorias[1].getNombre()) ) {
            categorias[1].eliminarProducto(prod);
        }
       if (categoria.equals(categorias[2].getNombre()) ) {
            categorias[2].eliminarProducto(prod);
        }
       if (categoria.equals(categorias[3].getNombre()) ) {
            categorias[3].eliminarProducto(prod);
        }   
       notificarObservadores("Producto vendido: " + prod.getNombre());
    }
    
    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void eliminarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificarObservadores(String mensaje) {
        for (Observador o : observadores) {
            o.actualizar(mensaje);
        }
    }
    
}
