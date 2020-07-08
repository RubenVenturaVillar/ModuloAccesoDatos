import java.io.*;

public class OperacionesFicheros {
    public static void main(String[] args) {
        Ficheros creando = new Ficheros();
        creando.directorios();
        creando.archivos();
    }
}

class Ficheros {
    public void directorios() {

        //Crear el directorio
        File ruta = new File("C:" + File.separator + "Ficheros Java");
        //Concatenando File.separator obviamos la /, para hacer que funcione tanto en Linux como en Windows.
        ruta.mkdir(); //Método que crea el directorio. Este no da error si ya existe.
    }

    public void archivos() {
        //Crear el archivo.
        //Si ya existe no hace nada.
        //Si no se hubiera creado el directorio previamente, daría error.
        File archivo = new File("C:" + File.separator + "Ficheros Java" + File.separator + "prueba_creando_un_fichero.txt");
        try {
            archivo.createNewFile(); //Método que la crea el archivo. Si ya existe da error
        } catch (IOException e) {
            System.out.println("Error e/s :"+e);
        }
        System.out.println(archivo.getName());              //Devuelve el nombre
        System.out.println(archivo.getAbsolutePath());      //Devuelve la ruta absoluta
        System.out.println(archivo.exists());               //True si existe
    }
}

