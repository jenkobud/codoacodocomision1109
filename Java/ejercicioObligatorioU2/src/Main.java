import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese su Nombre: ");
        String nombre = s.nextLine();
        System.out.println("Ingrese su Apellido: ");
        String apellido = s.nextLine();
        System.out.println("Ingrese su edad (SOLO NUMEROS): ");
        //Por alguna razón al utilizar s.nextInt() crea un salto de línea en el scanner y saltea hobbie.
        Integer edad = Integer.parseInt(s.nextLine());
        System.out.println("Ingrese un hobbie: ");
        String hobbie = s.nextLine();
        System.out.println("Ingrese su editor de código favorito: ");
        String editorDeCodigo = s.nextLine();
        System.out.println("Ingrese su sistema operativo utilizado: ");
        String so = s.nextLine();
        Persona p = new Persona( nombre, apellido, edad, hobbie, editorDeCodigo, so);
        System.out.println("+-------------------------------------------------+");
        System.out.println("Persona ingresada:\n");
        System.out.println(p);
        System.out.println("+-------------------------------------------------+");
    }
}
