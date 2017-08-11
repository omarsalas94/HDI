package Reportes;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class ReportesJSON {
    FileWriter fileWriter;

    public ReportesJSON(){ }

    public void crearArchivo(String nombreJson){
        try {
            fileWriter = new FileWriter("./src/test/java/Reportes/"+nombreJson+".json");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void escribirAcrhivo(JSONObject jsonObject){
        try {
            fileWriter.write(jsonObject.toJSONString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cerrarArchivo(){
        try {
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
