public class Character {
    private String name;
    int hit_points;
    int magic_points;
    boolean is_ally;
    private int age;

    public void validarEdad(int age) {
        if (age < 0) {
            System.out.println("Dado que le asignaste una edad negativa, el programa la dejo en 0");
            this.age = 0;
        } else {
            this.age = age;
        }

    }

    public int mostrarEdad() {
        return this.age;
    }

    public void validarNombre(String nombre_personaje) {
        String copia_nombre = nombre_personaje;
        copia_nombre.toLowerCase();
        copia_nombre.strip();
        switch (copia_nombre) {
            case "weon":
                this.name = "****";
                break;
            case "makako":
                this.name = "******";
                break;
            case "nigga":
                this.name = "*****";
                break;
            case "brazuka":
                this.name = "*******";
                break;
            case "faggy":
                this.name = "*****";
                break;
            case "fagot":
                this.name = "*****";
                break;
            default:
                this.name = nombre_personaje;
                break;
        }
    }

    public String mostrarNombre() {
        return this.name;
    }
}
