public class Character {
    private String name;
    int hit_points;
    int magic_points;
    boolean is_ally;
    private int age;

    public void validarEdad(int age){
        if (age < 0){
            System.out.println("Dado que le asignaste una edad negativa, el programa la dejo en 0");
            this.age = 0;
        } else{
            this.age = age;
        }
    }
    public int mostrarEdad(){
        return this.age;
    }
    
    public String validarNombre(String name){
        String copia_nombre = name;
        copia_nombre.toLowerCase();
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
                break;
        }
        this.name = name;
    }
    public String mostrarNombre(){
        return this.name;
    }
}
