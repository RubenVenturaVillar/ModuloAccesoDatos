import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CrearFichero {
    public static void main(String[] args) throws IOException {

        //Para crear el directorio
        File ruta = new File("C:"+File.separator+"Users"
                +File.separator+"ruben"+File.separator+"IdeaProjects"
                +File.separator+"Acceso a datos"+File.separator+"Creación de ficheros");
            ruta.mkdir(); //Método que la crea. Este no da erro


        //Crear el archivo
        File archivo = new File("C:"+File.separator+"Users"
                +File.separator+"ruben"+File.separator+"IdeaProjects"
                +File.separator+"Acceso a datos"+File.separator+"Creación de ficheros"
                +File.separator+"prueba_texto.txt");
        try {
            archivo.createNewFile();; //Método que la crea el archivo. Si ya existe da error.
        }catch (IOException e) {
            System.out.println("El fichero ya existe");
        }

        System.out.println(archivo.getName());              //Devuelve el nombre
        System.out.println(archivo.getAbsolutePath());      //Devuelve la ruta absoluta
        System.out.println(archivo.exists());               //True si existe


        //Escritura
        FileWriter escritura = new FileWriter(archivo);
        escritura.write("Esto es una prueba\n");
        escritura.write("Otra pruba");
        escritura.flush();
        escritura.close();

    }
}
