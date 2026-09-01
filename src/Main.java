import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        showMenu();

    }

    static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        Character player_Character = new Character();
        Enderman enderman = new Enderman();
        Creeper creeper = new Creeper();
        Zombie zombie = new Zombie();
        Dragon dragon = new Dragon();

        boolean flag_menu = true;

        System.out.println("****WELCOME TO THE SEVEN KINGDOMS****");

        while (flag_menu) {
            System.out.println("1.- CREATE CHARACTER");
            System.out.println("2.- VIEW CHARACTER");
            System.out.println("3.- EXIT");
            System.out.println("4.- TESTEANDO COSITAS");

            System.out.println("CHOOSE AN OPTION");

            String user_option = scanner.nextLine();
            switch (user_option) {
                case "1":
                    createCharacter(player_Character, scanner);
                    break;
                case "2":
                    viewCharacter(player_Character);
                    break;
                case "3":
                    System.out.println("GRACIAS POR JUGAR, VUELVA PRONTO");
                    flag_menu = false;
                    break;
                case  "4":
                    testeandoCositas();
                    break;
                default:
                    System.out.println("OPCIÓN INVALIDA");
                    break;
            }
        }
    }

    static void testeandoCositas(){
        System.out.println("Cositas del zombie");
        Zombie zombie = new Zombie();
        zombie.atacar();
        zombie.infectarAldeano();
    }




    static void createCharacter(Character player_Character, Scanner scanner) {

        System.out.println("CREATING CHARACTER");

        // ASIGNAR NOMBRE
        System.out.println("INGRESE UN NOMBRE");
        player_Character.validarNombre(scanner.nextLine());

        // ASIGNAR HP
        System.out.println("INGRESE LOS PUNTOS DE VIDA");
        player_Character.hit_points = Integer.parseInt(scanner.nextLine());

        // ASIGNAR PM
        System.out.println("INGRESE LOS PUNTOS DE MAGIA");
        player_Character.magic_points = Integer.parseInt(scanner.nextLine());

        // Asignar edad
        System.out.println("INGRESE LA EDAD");
        player_Character.validarEdad(Integer.parseInt(scanner.nextLine()));
    }

    static void viewCharacter(Character player_Character) {
        System.out.println("VER PERSONAJE");
        System.out.println("NAME: " + player_Character.mostrarNombre());
        System.out.println("HP: " + player_Character.hit_points);
        System.out.println("MP: " + player_Character.magic_points);
        System.out.println("AGE: " + player_Character.mostrarEdad());
    }

    static void createEnderman(Enderman enderman, Scanner scanner) {
        System.out.println("CREATING CHARACTER");
        System.out.println("INGRESE UN NOMBRE");
        enderman.validarNombre(scanner.nextLine());

        System.out.println("INGRESE LOS PUNTOS DE VIDA");
        enderman.hit_points = Integer.parseInt(scanner.nextLine());

        System.out.println("INGRESE LOS PUNTOS DE MAGIA");
        enderman.magic_points = Integer.parseInt(scanner.nextLine());

        System.out.println("INGRESE LA EDAD");
        enderman.validarEdad(Integer.parseInt(scanner.nextLine()));
    }

    static void createCreeper(Creeper creeper, Scanner scanner) {
        System.out.println("CREATING CHARACTER");
        System.out.println("INGRESE UN NOMBRE");
        creeper.validarNombre(scanner.nextLine());

        System.out.println("INGRESE LOS PUNTOS DE VIDA");
        creeper.hit_points = Integer.parseInt(scanner.nextLine());

        System.out.println("INGRESE LOS PUNTOS DE MAGIA");
        creeper.magic_points = Integer.parseInt(scanner.nextLine());

        System.out.println("INGRESE LA EDAD");
        creeper.validarEdad(Integer.parseInt(scanner.nextLine()));
    }

}