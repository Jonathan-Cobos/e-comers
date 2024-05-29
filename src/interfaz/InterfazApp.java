
package interfaz;

import java.util.Scanner;
import mundo.*;

 
public class InterfazApp {

    private Usuario usuario;
    private Server server;
    private Scanner scan; 
    
    public InterfazApp() {
        server = new Server();
        this.usuario = usuario;
        scan = new Scanner(System.in);
    }
    
    public void aplicarDescuento(Productos prod, int descuento) {
        Producto productoConDescuento = new ProductoConDescuento(prod, descuento);
        System.out.println("Producto con descuento: " + productoConDescuento.getNombre() + ", Precio: " + productoConDescuento.getPrecio());
    }
    
    public void procesarPago(int monto) {
        SistemaPago sistemaPago = new AdaptadorPago(new ProcesadorPago());
        sistemaPago.procesarPago(monto);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
    
    
    public void publicarProductos(Productos prod){
        
        server.publicarProducto(prod);
    }
    
    public void venderProductos(){
        Productos prod = usuario.comprarProducto();
        procesarPago(prod.getPrecio());
        usuario.imprimirCarrito();
        server.venderProducto(prod);
    } 
    
    public int menu(InterfazApp iapp){
        System.out.println("bienvenido  e-commerce \n"
        + "1. ingresar usuario: \n" 
        + "2. publicar producto: \n"
        + "3. agregar un producto al carro de compras: \n"
        + "4. comprar un producto \n"
        + "5. eliminar un producto del carrito\n");
        
        int a = 0;
        System.out.println("");
        System.out.println("ingrese una opción: ");
        a = scan.nextInt();
        
        switch (a) {
            case 1:
                System.out.println("ingrese nombre de usuario: ");
                String nombre = scan.next();
                System.out.println("ingrese contraseña: ");
                int contraseña = scan.nextInt();
                System.out.println("ingrese direccion: ");
                String direccion = scan.next();
                
                Usuario user = new Usuario(nombre, contraseña, direccion);
                server.agregarObservador(user);
                iapp.setUsuario(user);
                menu(iapp);         
                
                break;
             case 2:
                Productos prod = usuario.publicarProductos();
                publicarProductos(prod);
                iapp.server.publicarProducto(prod);
                aplicarDescuento(prod, 200);
                menu(iapp);
                break;
             case 3:
                 System.out.println("Escriba una categoria: \n"
                         + "1. electrodomesticos \n"
                         + "2. aseo\n"
                         + "3. papeleria\n"
                         + "4. otros\n");
                 
                 String categoria = scan.next();
                 System.out.println("---------------------------");
                 server.consultarProductos(categoria);
                 System.out.println("escribe el nombre del producto: ");
                 String nom = scan.next();
                 Productos product = server.obtenerProducto(categoria, nom);                                 
                 usuario.addCarrito(product);
                 menu(iapp);
                break;
             case 4:
                 venderProductos();
                 menu(iapp);
                break;
             case 5:
                 System.out.println("escriba el nombre del producto a eliminar:");
                 String nomb = scan.next();
                usuario.imprimirCarrito();
                usuario.retirarProducto(nomb);
                usuario.imprimirCarrito();
                menu(iapp);
                break;    
            default:
                throw new AssertionError();
        }
        return a;    
    }
    
    public static void main(String[] args) {      
        Scanner scan = new Scanner(System.in);
        InterfazApp app = new InterfazApp();
        
        app.menu(app);              
    
    }
    
    
    
}
