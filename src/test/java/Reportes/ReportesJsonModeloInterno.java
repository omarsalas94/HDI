package Reportes;

import org.json.simple.JSONObject;

public class ReportesJsonModeloInterno {
    private String nombre;
    private String esperado;
    private String recibido;
    private String status;
    private JSONObject object;

    public ReportesJsonModeloInterno(){ }

    public ReportesJsonModeloInterno(String nombre, String esperado, String recibido, String status){
        this.nombre = nombre;
        this.esperado = esperado;
        this.recibido = recibido;
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEsperado() {
        return esperado;
    }

    public void setEsperado(String esperado) {
        this.esperado = esperado;
    }

    public String getRecibido() {
        return recibido;
    }

    public void setRecibido(String recibido) {
        this.recibido = recibido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JSONObject getObjectInterno(){
        object = new JSONObject();
        object.put("nombre",nombre);
        object.put("esperado",esperado);
        object.put("recibido",recibido);
        object.put("status",status);

        return object;
    }
}
