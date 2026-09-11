package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.MenuBancaPrivadaPage;

public class MenuBancaPrivadaTest extends BaseTest {

    @Test
    public void validarNavegacionBancaPrivada() throws InterruptedException {
        MenuBancaPrivadaPage menuBancaPrivada = new MenuBancaPrivadaPage(driver);

        menuBancaPrivada.clicTabBancaPrivada();

        Thread.sleep(3000);

        menuBancaPrivada.clicQuienesSomos();
        Thread.sleep(2000);

        menuBancaPrivada.clicProductos();
        Thread.sleep(2000);

        menuBancaPrivada.clicPodcast();
        Thread.sleep(2000);
    }
}