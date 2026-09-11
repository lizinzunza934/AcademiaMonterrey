package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuBancaPrivadaPage extends BasePage {


    private By tabBancaPrivada = By.xpath("//button[contains(@aria-label, 'privada')] | //a[contains(text(), 'Banca Privada')] | //div[contains(text(), 'Banca Privada')]");

    private By linkQuienesSomos = By.xpath("//a[contains(@href, '/bp/quienes')]");
    private By linkProductos = By.xpath("//a[contains(@href, '/bp/productos')]");
    private By linkPodcast = By.xpath("//a[contains(@href, '/bp/podcast')]");

    public MenuBancaPrivadaPage(WebDriver driver) {
        super(driver);
    }

    public void clicTabBancaPrivada() {
        clickJS(tabBancaPrivada);
    }

    public void clicQuienesSomos() {
        clickJS(linkQuienesSomos);
    }

    public void clicProductos() {
        clickJS(linkProductos);
    }

    public void clicPodcast() {
        clickJS(linkPodcast);
    }
}