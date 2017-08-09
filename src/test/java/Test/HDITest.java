package Test;

import Pages.PageCotizadorWeb;
import Pages.PageCotizar;
import Pages.PageLogin;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HDITest extends Setup{
    PageLogin pageLogin;
    PageCotizar pageCotizar;
    PageCotizadorWeb pageCotizadorWeb;

    @BeforeTest
    public void configuracionDriver(){
        setup();
    }

    @AfterTest
    public void finlizacionTest(){
        cerrarNavegador();
    }

    @Test
    public void Test(){
        pageLogin = new PageLogin(driver,"430003354","Pa55word");
        pageLogin.escribirUsuario();
        pageLogin.escribirContrasena();
        pageLogin.clicIngresar();

        pageCotizar = new PageCotizar(driver);
        pageCotizar.clicCotizar();

        pageCotizadorWeb = new PageCotizadorWeb(driver);
        pageCotizadorWeb.clicComboBox();
        pageCotizadorWeb.seleccionaComboBox("214 OFICINA SALAMANCA");

    }


}
