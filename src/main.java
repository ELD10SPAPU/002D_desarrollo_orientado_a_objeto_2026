import java.util.ArrayList;
import java.util.Scanner;

public class main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Autor> autores = new ArrayList<>();
    public static void main(String[] args) {
        mostrarMenu();
    }
    static void mostrarMenu() {
        boolean mostrar_menu = true;
        System.err.println("****Inicio de programa****");

        while (mostrar_menu ) {
            System.out.println("1. Crear autor");
            System.out.println("2. Mostrar todos los autores");
            System.out.println("3. Buscar un autor según su ID");
            System.out.println("9. Salir");
            String opcion_menu = sc.nextLine();
            switch (opcion_menu) {
                case "1":
                crearAutor();
                    break;
                case "2":
                mostrarAutor();
                    break;
                case "3":
                buscarAutorSegunID();
                    break;
                case "9":
                mostrar_menu = false;
                    break;

                default:
                    break;
            }
        }
    }

    static void crearAutor(){
        Autor autor = new Autor(0, null);
        
    }   
    static void mostrarAutor(){
        for (int i = 0; i < autores.length; i++) {
            System.out.println("Nombre: " + autores.get(i))
        };
    }
    static void buscarAutorSegunID(){
        System.out.println("Ingrese el ID de el autor");
        Integer.parseInt(sc.nextLine());
    }
}
