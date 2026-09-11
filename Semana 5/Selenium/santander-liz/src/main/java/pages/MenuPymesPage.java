package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPymesPage extends BasePage {

    private By tabPymes = By.xpath("//button[contains(@aria-label, 'pyme')] | //a[contains(translate(., 'PYMES', 'pymes'), 'pymes')] | //div[contains(translate(., 'PYMES', 'pymes'), 'pymes')]");

    private By linkSantanderPyme = By.xpath("//a[contains(., 'Santander Pyme')]");
    private By linkPaquetesPymes = By.xpath("//a[contains(., 'Paquetes Pymes')]");
    private By linkNegocioTransaccional = By.xpath("//a[contains(., 'Negocio transaccional')]");
    private By linkDivisasCoberturas = By.xpath("//a[contains(., 'Divisas y coberturas')]");
    private By linkNegocioInternacional = By.xpath("//a[contains(., 'Negocio internacional')]");
    private By linkAlianzas = By.xpath("//a[contains(., 'Alianzas')]");
    private By linkEcosistema = By.xpath("//a[contains(., 'Ecosistema no financiero')]");

    private By linkCuentas = By.xpath("//a[contains(@href, 'pyme') and contains(., 'Cuentas')]");
    private By linkSeguros = By.xpath("//a[contains(@href, 'pyme') and contains(., 'Seguros')]");
    private By linkInversiones = By.xpath("//a[contains(@href, 'pyme') and contains(., 'Inversiones')]");
    private By linkCreditos = By.xpath("//a[contains(@href, 'pyme') and contains(., 'Créditos')]");

    public MenuPymesPage(WebDriver driver) {
        super(driver);
    }

    public void clicTabPymes() {
        clickJS(tabPymes);
    }

    public void clicSantanderPyme() {
        clickJS(linkSantanderPyme);
    }

    public void clicCuentas() {
        clickJS(linkCuentas);
    }

    public void clicPaquetesPymes() {
        clickJS(linkPaquetesPymes);
    }

    public void clicSeguros() {
        clickJS(linkSeguros);
    }

    public void clicNegocioTransaccional() {
        clickJS(linkNegocioTransaccional);
    }

    public void clicInversiones() {
        clickJS(linkInversiones);
    }

    public void clicDivisasCoberturas() {
        clickJS(linkDivisasCoberturas);
    }

    public void clicNegocioInternacional() {
        clickJS(linkNegocioInternacional);
    }

    public void clicCreditos() {
        clickJS(linkCreditos);
    }

    public void clicAlianzas() {
        clickJS(linkAlianzas);
    }

    public void clicEcosistema() {
        clickJS(linkEcosistema);
    }
}