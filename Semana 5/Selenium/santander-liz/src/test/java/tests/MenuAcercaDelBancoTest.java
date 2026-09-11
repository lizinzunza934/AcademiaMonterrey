package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.MenuAcercaDelBancoPage;

public class MenuAcercaDelBancoTest extends BaseTest {

    @Test
    public void validarNavegacionAcercaDelBanco() throws InterruptedException {
        MenuAcercaDelBancoPage menuAcerca = new MenuAcercaDelBancoPage(driver);

        menuAcerca.clicTabAcercaDelBanco();
        menuAcerca.clicFundacionSantander();
        driver.navigate().back();
        Thread.sleep(2000);

        menuAcerca.clicTabAcercaDelBanco();
        menuAcerca.clicSostenibilidad();
        driver.navigate().back();
        Thread.sleep(2000);

        menuAcerca.clicTabAcercaDelBanco();
        menuAcerca.clicEducacionFinanciera();
        Thread.sleep(2000);

        menuAcerca.clicTabAcercaDelBanco();
        menuAcerca.clicInversionistas();
        Thread.sleep(2000);

        menuAcerca.clicTabAcercaDelBanco();
        menuAcerca.clicSalaComunicacion();
        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().back();

        menuAcerca.clicTabAcercaDelBanco();
        menuAcerca.clicBolsaTrabajo();
        Thread.sleep(2000);

        driver.navigate().back();

        menuAcerca.clicTabAcercaDelBanco();
        menuAcerca.clicBlog();
    }
}