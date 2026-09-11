package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuAcercaDelBancoPage extends BasePage {

    private By tabAcerca = By.xpath("//button[contains(translate(@aria-label, 'ACERCA', 'acerca'), 'acerca del banco')] | //a[contains(text(), 'Acerca del Banco')] | //div[contains(text(), 'Acerca del Banco')]");

    private By linkFundacion = By.xpath("//a[contains(., 'Fundación Santander')]");
    private By linkSostenibilidad = By.xpath("//a[contains(., 'Sostenibilidad')]");
    private By linkEducacion = By.xpath("//a[contains(., 'Educación Financiera')]");
    private By linkInversionistas = By.xpath("//a[contains(., 'Inversionistas')]");
    private By linkSalaComunicacion = By.xpath("//a[contains(., 'Sala de comunicación')]");
    private By linkBolsaTrabajo = By.xpath("//a[contains(., 'Bolsa de trabajo')]");
    private By linkBlog = By.xpath("//a[contains(., 'Blog')]");

    public MenuAcercaDelBancoPage(WebDriver driver) {
        super(driver);
    }

    public void clicTabAcercaDelBanco() {
        clickJS(tabAcerca);
    }

    public void clicFundacionSantander() {
        clickJS(linkFundacion);
    }

    public void clicSostenibilidad() {
        clickJS(linkSostenibilidad);
    }

    public void clicEducacionFinanciera() {
        clickJS(linkEducacion);
    }

    public void clicInversionistas() {
        clickJS(linkInversionistas);
    }

    public void clicSalaComunicacion() {
        clickJS(linkSalaComunicacion);
    }

    public void clicBolsaTrabajo() {
        clickJS(linkBolsaTrabajo);
    }

    public void clicBlog() {
        clickJS(linkBlog);
    }
}