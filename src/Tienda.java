import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    static ArrayList<ProductoFisico> coleccion_juegos_fisicos = new ArrayList<>();
    static ArrayList<ProductoDigital> coleccion_juegos_digitales = new ArrayList<>();
    //static ArrayList<Producto> carrito = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    static void mostrarMenu() {
        boolean mostrar_menu = true;

        while (mostrar_menu) {
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar inventario");
            System.out.println("3. Buscar producto por nombre");
            System.out.println("4. Vender producto");
            System.out.println("5. Resumen del inventario");
            System.out.println("6. Salir");
            System.out.println("7. Agregar datos de prueba");
            System.out.println("--Seleccione una opción--");
            String opcion_menu = sc.nextLine();
            switch (opcion_menu) {
                case "1":
                    registrarProducto();
                    break;
                case "2":
                    listarInventario();
                    break;
                case "3":
                    buscarProductoPorNombre();
                    break;
                case "4":
                    venderProducto();
                    break;
                case "5":

                    break;
                case "6":
                    mostrar_menu = false;
                    break;
                case "7":
                    agregarDatosDePrueba();
                    break;
                default:
                    break;
            }
        }
    }

    static void registrarProducto() {
        boolean mostrar_menu = true;
        while (mostrar_menu) {
            System.out.println("1. Producto físico");
            System.out.println("2. Producto digital");
            System.out.println("3. Volver al menú");
            System.out.println("--Seleccione una opción--");
            String opcion_menu = sc.nextLine();
            switch (opcion_menu) {
                case "1":
                    registrarProductoFisico();
                    break;
                case "2":
                    registrarProductoDigital();
                    break;
                case "3":
                    mostrar_menu = false;
                    break;

                default:
                    break;
            }
        }
    }

    static public void registrarProductoFisico() {
        System.out.println("Ingrese el nombre del juego");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el precio base del juego");
        int precioBase = Integer.parseInt((sc.nextLine()));
        System.out.println("Ingrese el stock del juego");
        int stock = Integer.parseInt((sc.nextLine()));
        System.out.println("Ingrese el costo de envio del juego");
        int costoEnvio = Integer.parseInt((sc.nextLine()));
        ProductoFisico juego = new ProductoFisico(nombre, precioBase, stock, costoEnvio);
        if (coleccion_juegos_fisicos.add(juego)) {
            System.out.println("Juego agregado");
        } else {
            System.out.println("No se pudo agregar :C");
        }
    }

    static public void registrarProductoDigital() {
        System.out.println("Ingrese el nombre del juego");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el precio base del juego");
        int precioBase = Integer.parseInt((sc.nextLine()));
        System.out.println("Ingrese el stock del juego");
        int stock = Integer.parseInt((sc.nextLine()));
        System.out.println("Ingrese el descuento del juego");
        int descuento = Integer.parseInt((sc.nextLine()));
        System.out.println("Ingrese la plataforma del juego");
        String plataforma = sc.nextLine();
        ProductoDigital juego = new ProductoDigital(nombre, precioBase, stock, descuento, plataforma);

        if (coleccion_juegos_digitales.add(juego)) {
            System.out.println("Juego agregado");
        } else {
            System.out.println("No se pudo agregar :C");
        }
    }

    static public void listarInventario() {
        System.out.println("****INVENTARIO DE JUEGOS FÍSICOS****");
        for (ProductoFisico juego_fisco : coleccion_juegos_fisicos) {
            System.out.println(juego_fisco.mostrarInfo());
        }
        System.out.println("****INVENTARIO DE JUEGOS DIGITAL****");
        for (ProductoDigital juego_digial : coleccion_juegos_digitales) {
            System.out.println(juego_digial.mostrarInfo());
        }
    }

    static void agregarDatosDePrueba() {
        System.out.println("Agregando datos de prueba");

        coleccion_juegos_fisicos.add(new ProductoFisico("Pokemon Perla", 27000, 20, 3000));
        coleccion_juegos_fisicos.add(new ProductoFisico("Pokemon Diamante", 27000, 14, 3000));
        coleccion_juegos_fisicos.add(new ProductoFisico("GTA V", 32000, 26, 3000));
        coleccion_juegos_fisicos.add(new ProductoFisico("Majoras Mask", 150000, 2, 3000));
        coleccion_juegos_fisicos.add(new ProductoFisico("Pay Day 2", 6000, 6, 3000));

        coleccion_juegos_digitales.add(new ProductoDigital("Halo", 9000, 20, 45, "PC"));
        coleccion_juegos_digitales.add(new ProductoDigital("Balatro", 12000, 46, 5, "PC"));
    }

    static void buscarProductoPorNombre() {
        System.out.println("Ingrese nombre del juego: ");
        String nombre_juego = sc.nextLine();

        for (ProductoFisico juego_fisico : coleccion_juegos_fisicos) {
            if (juego_fisico.getNombre().contains(nombre_juego)) {
                System.out.println(juego_fisico.mostrarInfo());
            }
        }

        for (ProductoDigital juego_digital : coleccion_juegos_digitales) {
            if (juego_digital.getNombre().contains(nombre_juego)) {
                System.out.println(juego_digital.mostrarInfo());
            }
        }
    }

    static void venderProducto() {
        ArrayList<ProductoFisico> carrito_juegos_fisicos = new ArrayList<>();
        ArrayList<ProductoDigital> carrito_juegos_digitales = new ArrayList<>();
        coleccion_juegos_digitales.clone();
        coleccion_juegos_fisicos.clone();
        boolean mostrar_menu = true;
        while (mostrar_menu) {
            System.out.println("1. Agregar al carrito");
            System.out.println("2. Ver carrito");
            System.out.println("3. Pagar");
            System.out.println("4. Volver al menú");
            System.out.println("--Seleccione una opción--");
            String opcion_menu = sc.nextLine();
            switch (opcion_menu) {
                case "1":
                    agregarCarrito();
                    break;
                case "2":
                    verCarrito();
                    break;
                case "3":
                    pagarCarrito();
                    break;
                case "4":
                    mostrar_menu = false;
                    break;
                default:
                    break;
            }
        }
    }
    static void agregarCarrito(){
        listarInventario();
        System.out.println("Ingrese el nombre de el producto que desea: ");
        String juego_carrito = sc.nextLine();
        
    }
    static void verCarrito(){

    }
    static void pagarCarrito(){

    }
}
