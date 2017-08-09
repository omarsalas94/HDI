package Reportes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ReportesJsonModeloExterno {
    private String nombre;
    private JSONArray arrayInterno;
    private JSONObject object;
    private ReportesJsonModeloInterno modeloInterno;

    public ReportesJsonModeloExterno(){}

    public ReportesJsonModeloExterno(String nombre, JSONArray arrayInterno){
        this.nombre = nombre;
        this.arrayInterno = arrayInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JSONArray getArrayInterno() {
        return arrayInterno;
    }

    public void setArrayInterno(JSONArray arrayInterno) {
        this.arrayInterno = arrayInterno;
    }

    public JSONObject getObjectExterno(){
        object = new JSONObject();
        object.put("nombre", nombre);
        object.put("pruebas", arrayInterno);

        return object;
    }
}
