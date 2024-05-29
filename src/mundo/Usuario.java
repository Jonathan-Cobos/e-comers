
package mundo;

import java.util.ArrayList;
import java.util.Scanner;


public class Usuario implements Observador{
 
    private String nombre;
    private int contraseña;
    private Productos[] carrito;
    private String direccion;
    private int i;
    private Scanner scan;

    public Usuario(String nombre, int contraseña, String direccion) {
        i = 0;
        scan = new Scanner(System.in);
        this.nombre = nombre;
        this.contraseña = contraseña;
        carrito = new Productos[5];
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public Productos[] getCarrito() {
        return carrito;
    }

    public void addCarrito(Productos prod) {
       if (i < carrito.length) {
        carrito[i++] = prod;
       } else {
        System.out.println("El carrito está lleno");
      }
       imprimirCarrito();
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public Productos consultarProductos(String nombre){
        int pos = 0;
        for (int i = 0; i < 5; i++) {
            if (nombre.toUpperCase().equals(carrito[i].getNombre().toUpperCase())) {
               pos = i;   
            }
            
        }
        return carrito[pos];
        
    }
    
    public Productos publicarProductos(){
       
        System.out.println("ingrese el nombre: ");
        String nombre = scan.next();
        System.out.println("ingrese el precio: ");
        int precio = scan.nextInt();
        System.out.println("ingrese la categoria: ");
        String categoria = scan.next();
        Productos prod = new Productos(nombre, precio, categoria);
        
        return prod;
        
    }
    
    public void retirarProducto(String nombre){
        for (int i = 0; i < carrito.length; i++) {
            if (carrito[i] != null && nombre.toUpperCase().equals(carrito[i].getNombre().toUpperCase())) {
                for (int j = i; j < carrito.length - 1; j++) {
                    carrito[j] = carrito[j + 1];
                }
                carrito[carrito.length - 1] = null;
                i--;  // Ajustar índice por si hay productos consecutivos con el mismo nombre
                break; // Si solo quieres eliminar el primer producto encontrado con ese nombre
            }
        }
    }
    
    public void imprimirCarrito(){
        for (int i = 0; i < carrito.length; i++) {
            if (carrito[i] != null) { 
            System.out.println("posicion " + (i+1) + ": " + carrito[i].toString()); 
            }else{
                System.out.println("vacio");
            }
        }                
    }
    
    public Productos comprarProducto(){
        
        System.out.println("digite el numero del producto en el carrito a comprar:");
        imprimirCarrito();
        int a =  scan.nextInt();
        Productos prod;
        switch (a) {
            case 1:
                prod = carrito[0];
               retirarProducto(prod.getNombre());
               return prod;               
            case 2:
                prod = carrito[1];
               retirarProducto(prod.getNombre());
               return prod;  
               
            case 3:
                prod = carrito[2];
               retirarProducto(prod.getNombre());
               return prod;  
               
            case 4:
                prod = carrito[3];
               retirarProducto(prod.getNombre());
               return prod;  
              
            case 5:
                prod = carrito[4];
               retirarProducto(prod.getNombre());
               return prod;  
                
            default:
                throw new AssertionError();
        }      
    }
    
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Notificación para " + nombre + ": " + mensaje);
    }

    
}
