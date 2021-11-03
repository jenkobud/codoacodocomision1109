public class Persona {
    private String nombre, apellido, hobbie, editorDeCodigo, so;
    private Integer edad;

    Persona(String nombre,String  apellido,int edad,String  hobbie,String  editorDeCodigo,String so){
        this. nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.hobbie = hobbie;
        this.editorDeCodigo = editorDeCodigo;
        this.so = so;
    }

    @Override
    public String toString() {
        return "Nombre completo: "+ this.nombre +" "+ this.apellido
                + "\nEdad: "+ this.edad
                + "\nHobbie: "+ this.hobbie
                + "\nEditor de código: " + this.editorDeCodigo + "     SO: " + this.so;
    }
}
