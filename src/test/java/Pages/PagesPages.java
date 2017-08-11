package Pages;

import Reportes.ReportesJSON;
import Reportes.ReportesJsonModeloInterno;
import org.json.simple.JSONArray;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PagesPages {
    WebDriver driver;

    PageLogin pageLogin;
    PageCotizar pageCotizar;
    PageCotizadorWeb pageCotizadorWeb;

    /*PRUEBASADSDFKGALKSGLKFJGLKASJGLAJG*/
    ReportesJsonModeloInterno interno;
    String nombres[] = {
            "DAÑOS MATERIALES",
            "ROBO TOTAL",
            "RESPONSABILIDAD CIVIL LUC.",
            "ASISTENCIA JURÍDICA",
            "GASTOS MÉDICOS POR OCUPANTE",
            "RESPONSABILIDAD CIVIL EN EXCESO POR MUERTE A PERSONAS",
            "RESPONSABILIDAD CIVIL FAMILIAR",
            "ASISTENCIA EN VIAJES",
            "ASISTENCIA MEDICA"
    };

    ReportesJSON json;

    public PagesPages(WebDriver driver) {
        this.driver = driver;
    }

    public void procesoUnico() {
        pageLogin = new PageLogin(driver, "430003354", "Pa55word");
        pageLogin.escribirUsuario();
        pageLogin.escribirContrasena();
        pageLogin.clicIngresar();


        pageCotizar = new PageCotizar(driver);
        pageCotizar.clicCotizar();


        pageCotizadorWeb = new PageCotizadorWeb(driver);


        //dfalksjfsdajfasjflaksjflasdjflajkdfjlsakdjfñlasdjf
        json = new ReportesJSON();
        json.crearArchivo("prueba");

    }

    public void procesoRepetir(String oficina, String cp, String tipo, String marca, String modelo, String submarca, String version) {
        pageCotizadorWeb.clicComboBox();
        pageCotizadorWeb.buscarOficina(oficina);
        pageCotizadorWeb.ingresarCP(cp);
        pageCotizadorWeb.seleccionarVehiculo(tipo, marca, modelo, submarca, version);
        pageCotizadorWeb.datos1();
        pageCotizadorWeb.clicTarificar();
        pageCotizadorWeb.datos2();

        realizarAsserts();
        json.cerrarArchivo();//adjfalkjfakfdjklasjdfkajslfdjasldjflasdjfldsajflkd

        driver.navigate().refresh();
        pageCotizadorWeb.esperar(7);

    }

    public void realizarAsserts() {
        String status = "";
        for (int i = 0; i < pageCotizadorWeb.getDatos1().size(); i++) {
            try {
                Assert.assertEquals(pageCotizadorWeb.getDatos1().get(i), pageCotizadorWeb.getDatos2().get(i));
                status = "Pasada";
            } catch (AssertionError error) {
                status = "Fallada";
            }
            interno = new ReportesJsonModeloInterno(
                    nombres[i],
                    pageCotizadorWeb.getDatos1().get(i),
                    pageCotizadorWeb.getDatos2().get(i),
                    status
            );

            json.escribirAcrhivo(interno.getObjectInterno());
        }
    }
}
