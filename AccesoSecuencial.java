import java.io.*;
import java.util.Scanner;

/*
En el acceso secuencial, para acceder a un dato concreto del archivo,
es necesario leer todo lo anterior,
por lo que los datos o registros se leen y escriben de forma ordenada.
No permite insertar un dato entre los que ya están escritos.
 */
public class AccesoSecuencial {
    public static void main(String[] args) {
        //Primero creamos el directorio
        Ficheros creando = new Ficheros();
        creando.directorios();

        Secuencial prueba = new Secuencial();
        //prueba.escritura();
        //prueba.lecturaCaracter();
        prueba.escrituraBuffer();
    }
}

class Secuencial {
    //Escritura secuencial.
    public void escritura() {
        try {
            FileWriter fw = new FileWriter("C:" + File.separator + "Ficheros Java" +
                    File.separator + "prueba_secuencial.txt", true);
            //Con true hacemos que escriba al final. Sin true borra el fichero y luego escribe.
            fw.write("Lorem ipsum dolor sit amet,\n");
            fw.write("consectetur adipiscing elit. \n");
            fw.write("Lorem ipsum dolor sit amet,\n");
            fw.write("consectetur adipiscing elit. \n");
            fw.flush();
            /* flush Se utiliza para recargar. En caso de que tengamos abierto un fichero para lectura,
            con el flush no tendríamos que cerrarlo y volverlo a abrir para utilizarlo en escritura */
            fw.close();
        } catch (IOException e) {
            System.out.println("Error e/s: " + e);
        }
    }

    //Flujo de lectura por caracteres
    public void lecturaCaracter() {
        try {
            FileReader rc = new FileReader("C:" + File.separator + "Ficheros Java" +
                    File.separator + "prueba_secuencial.txt");
            //Leemos el fichero y lo mostramos por pantalla
            int valor = rc.read();
            while (valor != -1) {
                System.out.print((char) valor);
                valor = rc.read();
            }
            rc.close();
        } catch (IOException e) {
            System.out.println("error E/S: " + e);
        }
    }



    public void escrituraBuffer() {
        //Flujo de escritura
        try {
            BufferedWriter bufferW = new BufferedWriter(new FileWriter("C:" + File.separator
                    + "Ficheros Java" + File.separator + "otra_prueba_secuencial.txt", true));
            //El valor true hace que escribamos al final del archivo.
            Scanner sc = new Scanner(System.in);                //Se crea el lector
            System.out.println("Introduce un dato");            //Se pide un dato al usuario
            bufferW.write(sc.nextLine());                       //Método para escribir
            bufferW.write("\n");
            bufferW.close();                                    //Siempre cerrar el buffer al terminar
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }

    public void lecturaLinea() {
        //Flujo de lectura línea a línea
        try {
            BufferedReader bufferR = new BufferedReader(new FileReader("C:" + File.separator
                    + "Ficheros Java" + File.separator + "otra_prueba_secuencial.txt"));
            String linea;
            while ((linea = bufferR.readLine()) != null) {
                System.out.println(linea);
            }
            bufferR.close();
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
        }
    }
}

