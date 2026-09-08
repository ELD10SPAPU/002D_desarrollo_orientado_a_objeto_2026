import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    static void mostrarMenu() {
        boolean mostrar_menu = true;
        System.err.println("****Inicio de programa****");

        while (mostrar_menu ) {
            System.err.println("1. Probando array");
            System.err.println("2. Probandao arrayList");
            System.err.println("9. Salir");
            String opcion_menu = sc.nextLine();
            switch (opcion_menu) {
                case "1":
                probandoArray();
                    break;
                case "2":
                probandoArrayList();
                    break;
                case "9":
                mostrar_menu = false;
                    break;

                default:
                    break;
            }
        }
    }

    static void probandoArray(){
        System.err.println("///////ESTUDIANES///////");

        String[] alumnos = new String[6];
        alumnos[0] = "Fernando Macias";
        alumnos[1] = "Tomás Barria";
        alumnos[2] = "Selena Figueroa";
        alumnos[3] = "Cristian Mancilla";
        alumnos[4] = "Francisco Almonacd";
        alumnos[5] = "Manuel Vivar";

        Integer[] edades = new Integer[6];
        edades[0] = 23;
        edades[1] = 18;
        edades[2] = 20;
        edades[3] = 10;
        edades[4] = 20;
        edades[5] = 20;


        //System.err.println("El esudiante " + alumnos[0] + " tiene " + edades[0] + " años.");

        for (int i = 0; i < edades.length; i++) {
            System.err.println("El esudiante " + alumnos[i] + " tiene " + edades[i] + " años.");
            
        }
    }

    static void probandoArrayList(){
        System.err.println("**********Probando arraylist**********");
        ArrayList<String> alumnos = new ArrayList<>();
        alumnos.add("Rogelio Huichacura");
        alumnos.add("Zinedine Argel");
        alumnos.add("Martin Cavero");
        alumnos.add("Gabriel Viveros");
        alumnos.add("Andrew Farías");
        alumnos.add("Nicole Aguilar");
        alumnos.add("Daniel Opazo");

        System.err.println(alumnos.get(2));

        for (String por_cada_alumno : alumnos) {
            System.out.println(por_cada_alumno);
            
        }
  }
}
