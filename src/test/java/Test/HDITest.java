package Test;

import Pages.PageLogin;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HDITest extends Setup{
    PageLogin pageLogin;

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
    }
}
