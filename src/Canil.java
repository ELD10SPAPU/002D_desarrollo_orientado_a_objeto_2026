public class Canil {
    public static void main(String[] args) {
    
        System.out.println("***Bienvenido al caníl***");

        Perro perro_del_profe = new Perro();
        perro_del_profe.nombre = "Gimli";
        perro_del_profe.edad = 6;
        perro_del_profe.peso = 40.5;
        perro_del_profe.tiene_vacuna = false;

        Perro perro_de_daniel = new Perro();
        perro_de_daniel.nombre = "Sultan";
        perro_de_daniel.edad = 10;
        perro_de_daniel.peso = 45.0;
        perro_de_daniel.tiene_vacuna = true;

        if (perro_de_daniel.edad > 2){
            System.out.println(perro_de_daniel.nombre + " tiene más de 2 años su edad es: " + perro_de_daniel.edad);
        } else {
            System.out.println(perro_de_daniel.nombre + " es menor a 2 años su edad es: " + perro_de_daniel.edad);
        }

        if (perro_de_daniel.peso > 20) {
            System.out.println(perro_de_daniel.nombre + " es un perro pesado pesa: " + perro_de_daniel);
        } else {
            System.out.println(perro_de_daniel.nombre + " es un perro ligero pesa: " + perro_de_daniel.peso);
        }
        if (perro_de_daniel.tiene_vacuna == true){
            System.out.println("Puede entrar al Canil");
        } else {
            System.out.println("Le hacen falta vacunas, no puede entrar al Canil");
        }


        //&& y
        //|| o
        //! negación
        System.out.println("Gracias por su visita");
    }
}
