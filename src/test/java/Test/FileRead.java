package Test;

import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileRead {
    File archivo;
    FileReader read;
    BufferedReader bufferedReader;
    ArrayList arraLineas, arrayPalabras;

    public ArrayList<ArrayList<String>> getLines(){
        arraLineas = new ArrayList();
        arrayPalabras = new ArrayList();

        try {
            archivo = new File("./src/test/Resources/Files/datos.txt");
            read = new FileReader(archivo);
            bufferedReader = new BufferedReader(read);
            String linea;
            while ((linea=bufferedReader.readLine())!= null){
                arrayPalabras = new ArrayList<String>();
                String palabras[] = linea.split(",");
                for (int i = 0; i < palabras.length ; i++) {
                    arrayPalabras.add(palabras[i]);
                }
                arraLineas.add(arrayPalabras);
            }
        }catch (IOException ex){

        }
        return arraLineas;
    }
}
