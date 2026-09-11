package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.MenuEmpresasPage;

public class MenuEmpresasTest extends BaseTest {

    @Test
    public void validarNavegacionMenuEmpresas() throws InterruptedException {
        MenuEmpresasPage menuEmpresas = new MenuEmpresasPage(driver);

        menuEmpresas.clicTabEmpresas();
        menuEmpresas.clicEmpresasGobierno();

        Thread.sleep(2000);

        menuEmpresas.clicTabEmpresas();
        menuEmpresas.clicMultinacionales();

        Thread.sleep(2000);

    }
}