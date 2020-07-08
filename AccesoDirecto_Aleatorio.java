import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AccesoDirecto_Aleatorio {
    public static void main (String[]args){
        //Acceso directo o aleatorio (Gestión de flujos)
        /*Permite acceder a un dato o registro que se encuentre en cualquier posición
        sin necesidad de hacer una lectura completa del archivo.
        Los datos se deben almacenar en registros con un tamaño conocido,
        para poder moverse de un registro a otro para cambiarlos o leerlos*/


        RandomAccessFile archivoAleatorio;                  //Declaramos un Objeto de la clase

        //Información a grabar en el archivo
        String codigo = "5555";         //4 caracteres
        String nombre = "Juan Vallés";  //11 caracteres
        String edad = "27";             //2 caracteres
        String peso = "85 Kg";          //5 caracteres
        String strActivo=" ";           //1 caracter para indicar si el registro está activo o no
        String strEOL = "\n";           //1 caracter
        int iLongitud=24;               //Longitud del registro

        try{
            archivoAleatorio = new RandomAccessFile("C:" + File.separator + "Ficheros Java" +
                    File.separator + "prueba_aleatorio.txt", "rw");
            System.out.println("La longitud del archivo es:"+archivoAleatorio.length());
            System.out.println("Registros del archivo: "+archivoAleatorio.length()/24);

            //Nos vamos al final del archivo
            archivoAleatorio.seek(archivoAleatorio.length());

            //Incorporamos la cadena al fichero
            archivoAleatorio.writeBytes(codigo);
            archivoAleatorio.writeBytes(nombre);
            archivoAleatorio.writeBytes(edad);
            archivoAleatorio.writeBytes(peso);
            archivoAleatorio.writeBytes(strActivo);
            archivoAleatorio.writeBytes(strEOL);

            archivoAleatorio.close();
        }catch (IOException e){

        }
    }
}
