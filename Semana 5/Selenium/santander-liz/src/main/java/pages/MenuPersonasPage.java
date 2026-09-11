package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPersonasPage extends BasePage {

    private By tabPersonas = By.xpath("//button[@aria-label='personas']");

    // CATEGORIA CREDITO Y FINANCIAMIENTO
    private By linkTarjetasCredito = By.xpath("//a[contains(., 'Tarjetas de crédito')]");
    private By linkCreditoPersonal = By.xpath("//a[contains(., 'Crédito personal')]");
    private By linkCreditoHipotecario = By.xpath("//a[contains(., 'Crédito hipotecario')]");
    private By linkSimuladorHipotecario = By.xpath("//a[contains(., 'Simulador de hipoteca')]");
    private By linkCreditoAutomotriz = By.xpath("//a[contains(@href, 'automotriz')]");
    private By linkBuroDeCredito = By.xpath("//a[contains(., 'Buró de crédito')]");

    // CANALES DIGITALES
    private By linkSantanderDigital = By.xpath("//a[contains(., 'Santander digital')]");
    private By linkAppSantander = By.xpath("//a[contains(., 'App Santander')]");
    private By linkSantanderWeb = By.xpath("//a[contains(., 'Santander Web')]");
    private By linkLimiteTransaccion = By.xpath("//a[contains(., 'Límite por transacción')]");

    //TIPO DE CUENTA
    private By linkCuentas = By.xpath("//a[contains(@href, 'personas') and contains(., 'Cuentas')]");
    private By linkBasica = By.xpath("//a[contains(., 'Básica')]");
    private By linkNomina = By.xpath("//a[text()='Nómina' or normalize-space()='Nómina']");
    private By linkCheques = By.xpath("//a[contains(., 'Cheques')]");
    private By linkPortabilidadNomina = By.xpath("//a[contains(., 'Portabilidad de nómina')]");

    // AHORRO E INVERSIÓN
    private By linkFondosInversion = By.xpath("//a[contains(., 'Fondos de inversión')]");
    private By linkInversionesPlazo = By.xpath("//a[contains(., 'Inversiones a plazo')]");
    private By linkNotasEstructuradas = By.xpath("//a[contains(., 'Notas estructuradas')]");

    // SEGUROS
    private By linkSeguroAuto = By.xpath("//a[contains(@href, 'seguro') and contains(., 'Auto')]");
    private By linkSeguroVida = By.xpath("//a[contains(@href, 'seguro') and contains(., 'Vida')]");
    private By linkSeguroHogar = By.xpath("//a[contains(@href, 'seguro') and contains(., 'Hogar')]");
    private By linkSeguroAhorro = By.xpath("//a[contains(@href, 'seguro') and text()='Ahorro']");
    private By linkGastosMedicos = By.xpath("//a[contains(., 'Gastos médicos')]");
    private By linkPertenencias = By.xpath("//a[contains(., 'Pertenencias')]");


    public MenuPersonasPage(WebDriver driver) {
        super(driver);
    }

    public void clicTabPersonas() { click(tabPersonas); }

    // CRÉDITO Y FINANCIAMIENTO
    public void clicTarjetasDeCredito() {
        click(linkTarjetasCredito);
    }

    public void clicCreditoPersonal() {
        click(linkCreditoPersonal);
    }

    public void clicCreditoHipotecario() {
        clickJS(linkCreditoHipotecario);
    }

    public void clicSimuladorHipotecario() {
        clickJS(linkSimuladorHipotecario);
    }

    public void clicCreditoAutomotriz() {
        clickJS(linkCreditoAutomotriz);
    }

    public void clicBuroDeCredito() {
        clickJS(linkBuroDeCredito);
    }

    // CANALES DIGITALES
    public void clicSantanderDigital() {
        clickJS(linkSantanderDigital);
    }

    public void clicAppSantander() {
        clickJS(linkAppSantander);
    }

    public void clicSantanderWeb() {
        clickJS(linkSantanderWeb);
    }

    public void clicLimiteTransaccion() {
        clickJS(linkLimiteTransaccion);
    }

    // TIPO DE CUENTA
    public void clicCuentas() {
        clickJS(linkCuentas);
    }

    public void clicBasica() {
        clickJS(linkBasica);
    }

    public void clicNomina() {
        clickJS(linkNomina);
    }

    public void clicCheques() {
        clickJS(linkCheques);
    }

    public void clicPortabilidadNomina() {
        clickJS(linkPortabilidadNomina);
    }

    // AHORRO E INVERSIÓN
    public void clicFondosInversion() {
        clickJS(linkFondosInversion);
    }

    public void clicInversionesPlazo() {
        clickJS(linkInversionesPlazo);
    }

    public void clicNotasEstructuradas() {
        clickJS(linkNotasEstructuradas);
    }

    // SEGUROS
    public void clicSeguroAuto() {
        clickJS(linkSeguroAuto);
    }

    public void clicSeguroVida() {
        clickJS(linkSeguroVida);
    }

    public void clicSeguroHogar() {
        clickJS(linkSeguroHogar);
    }

    public void clicSeguroAhorro() {
        clickJS(linkSeguroAhorro);
    }

    public void clicGastosMedicos() {
        clickJS(linkGastosMedicos);
    }

    public void clicPertenencias() {
        clickJS(linkPertenencias);
    }

}