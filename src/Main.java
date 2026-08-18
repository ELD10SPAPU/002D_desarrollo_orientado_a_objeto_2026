import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();


    }
    static void showMenu(){
        Scanner scanner = new Scanner(System.in);
        Character player_Character = new Character();
        boolean flag_menu = true;

        System.out.println("****WELCOME TO THE SEVEN KINGDOMS****");
        
        while (flag_menu) {
            System.out.println("1.- CREATE CHARACTER");
            System.out.println("2.- VIEW CHARACTER");
            System.out.println("3.- EXIT");

            System.out.println("CHOOSE AN OPTION");

            String user_option = scanner.nextLine();
            switch (user_option) {
                case "1":
                    System.out.println("CREATING CHARACTER");


                    System.out.println("INGRESE UN NOMBRE");
                    player_Character.name = scanner.nextLine();


                    System.out.println("INGRESE LOS PUNTOS DE VIDA");
                    player_Character.hit_points = Integer.parseInt(scanner.nextLine());
                    

                    System.out.println("INGRESE LOS PUNTOS DE MAGIA");
                    player_Character.magic_points = Integer.parseInt(scanner.nextLine());


                    System.out.println("INGRESE LOS PUNTOS DE MAGIA");
                    player_Character.magic_points = Integer.parseInt(scanner.nextLine());
                    
                    break;
            
                case "2":
                    System.out.println("VER PERSONAJE");
                    System.out.println("NOMBRE: " + player_Character.name);
                    System.out.println("HP: " + player_Character.hit_points);
                    System.out.println("MP: " + player_Character.magic_points);

                    break;

                case "3":
                    System.out.println("GRACIAS POR JUGAR, VUELVA PRONTO");
                    flag_menu = false;
                    break;
                default:
                    System.out.println("OPCIÓN INVALIDA");
                    break;
            }
        }
    }
}