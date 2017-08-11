package Test;

import Pages.PagesPages;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HDITest extends Setup {
    PagesPages pagesPages;
    FileRead fileRead;

    @BeforeTest
    public void configuracionDriver() {
        setup();
    }

    @AfterTest
    public void finlizacionTest() {
        cerrarNavegador();
    }

    @Test
    public void Test() {
        fileRead = new FileRead();
        pagesPages = new PagesPages(driver);

        pagesPages.procesoUnico();
        for (int i = 0; i < 1; i++) {
            pagesPages.procesoRepetir(
                    fileRead.getLines().get(i).get(0),
                    fileRead.getLines().get(i).get(1),
                    fileRead.getLines().get(i).get(2),
                    fileRead.getLines().get(i).get(3),
                    fileRead.getLines().get(i).get(4),
                    fileRead.getLines().get(i).get(5),
                    fileRead.getLines().get(i).get(6)
            );
        }

    }
}
