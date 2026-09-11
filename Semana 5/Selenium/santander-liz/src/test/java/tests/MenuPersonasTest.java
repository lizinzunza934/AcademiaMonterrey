package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.MenuPersonasPage;

public class MenuPersonasTest extends BaseTest {

    @Test
    public void validarNavegacionCompletaMenuPersonas() throws InterruptedException {
        MenuPersonasPage menuPersonas = new MenuPersonasPage(driver);

        //CRÉDITO Y FINANCIAMIENTO
        menuPersonas.clicTabPersonas();
        menuPersonas.clicTarjetasDeCredito();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicCreditoPersonal();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicCreditoHipotecario();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicSimuladorHipotecario();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicCreditoAutomotriz();
        driver.navigate().back();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicBuroDeCredito();
        driver.navigate().back();
        Thread.sleep(2000);

        // CANALES DIGITALES
        menuPersonas.clicTabPersonas();
        menuPersonas.clicSantanderDigital();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicAppSantander();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicSantanderWeb();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicLimiteTransaccion();
        Thread.sleep(2000);

        // TIPO DE CUENTA
        menuPersonas.clicTabPersonas();
        menuPersonas.clicCuentas();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicBasica();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicNomina();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicCheques();
        Thread.sleep(2000);

        menuPersonas.clicTabPersonas();
        menuPersonas.clicPortabilidadNomina();
        Thread.sleep(2000);

        // AHORRO E INVERSIÓN
        menuPersonas.clicTabPersonas();
        menuPersonas.clicFondosInversion();
        Thread.sleep(2000);

        menuPersonas.clicInversionesPlazo();
        Thread.sleep(2000);

        menuPersonas.clicNotasEstructuradas();
        Thread.sleep(2000);

        // SEGUROS
        menuPersonas.clicTabPersonas();
        menuPersonas.clicSeguroAuto();
        Thread.sleep(2000);

        menuPersonas.clicSeguroVida();
        Thread.sleep(2000);

        menuPersonas.clicSeguroHogar();
        Thread.sleep(2000);

        menuPersonas.clicSeguroAhorro();
        Thread.sleep(2000);

        menuPersonas.clicGastosMedicos();
        Thread.sleep(2000);

        menuPersonas.clicPertenencias();
        Thread.sleep(2000);
    }
}