package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.MenuPymesPage;

public class MenuPymesTest extends BaseTest {

    @Test
    public void validarNavegacionMenuPymes() throws InterruptedException {
        MenuPymesPage menuPymes = new MenuPymesPage(driver);

        menuPymes.clicTabPymes();
        menuPymes.clicSantanderPyme();
        Thread.sleep(2000);

        menuPymes.clicTabPymes();
        menuPymes.clicCuentas();
        Thread.sleep(2000);

        menuPymes.clicTabPymes();
        menuPymes.clicPaquetesPymes();
        Thread.sleep(2000);

        menuPymes.clicTabPymes();
        menuPymes.clicSeguros();
        Thread.sleep(2000);

        menuPymes.clicTabPymes();
        menuPymes.clicNegocioTransaccional();
        Thread.sleep(2000);

        menuPymes.clicTabPymes();
        menuPymes.clicInversiones();
        Thread.sleep(2000);

        menuPymes.clicTabPymes();
        menuPymes.clicDivisasCoberturas();
        Thread.sleep(2000);

        menuPymes.clicTabPymes();
        menuPymes.clicNegocioInternacional();
        Thread.sleep(2000);

        menuPymes.clicTabPymes();
        menuPymes.clicCreditos();
        Thread.sleep(2000);

        menuPymes.clicTabPymes();
        menuPymes.clicAlianzas();
        Thread.sleep(2000);

        menuPymes.clicTabPymes();
        menuPymes.clicEcosistema();
        Thread.sleep(2000);
    }
}