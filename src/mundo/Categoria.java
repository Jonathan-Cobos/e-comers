
package mundo;

import java.util.ArrayList;
import java.util.Iterator;


public class Categoria {
  
    private ArrayList<Productos> categoria;
    private String nombre;

    public Categoria(String nombre) {
        categoria = new ArrayList<>();
        this.nombre = nombre;
    }

    public ArrayList<Productos> getCategoria() {
        return categoria;
    }

    public void setCategoria(ArrayList<Productos> categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void guardarProducto(Productos prod){
        
        categoria.add(prod);
        
    }
    
    public void imprimirArreglo(){
        for (int i = 0; i < categoria.size(); i++) {
            System.out.println(categoria.get(i).toString()); 
        }                
    }
   
    public Productos obtenerProducto(String nombre){
        Productos prod = null;
        for (int i = 0; i < categoria.size(); i++) {                    
        if (nombre.equals(categoria.get(i).getNombre())) {
             prod = categoria.get(i);
          }else{
            System.out.println("producto no encontrado");
        }
        }
        return prod;
    }
    
    public int size(){
        
        return categoria.size();
        
    }
    
    public void eliminarProducto(Productos prod){
        Iterator<Productos> iterator = categoria.iterator();
    while (iterator.hasNext()) {
        if (iterator.next().equals(prod)) {
            iterator.remove();
            break;
        }
    }
    }
    
}
