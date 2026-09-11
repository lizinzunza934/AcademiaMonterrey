package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuEmpresasPage extends BasePage {

    private By tabEmpresas = By.xpath("//button[@aria-label='empresas'] | //a[contains(text(), 'Empresas')] | //div[contains(text(), 'Empresas')]");

    private By linkEmpresasGobierno = By.xpath("//a[contains(., 'Empresas y gobierno')]");
    private By linkMultinacionales = By.xpath("//a[contains(., 'Multinacionales')]");

    public MenuEmpresasPage(WebDriver driver) {
        super(driver);
    }


    public void clicTabEmpresas() {
        clickJS(tabEmpresas);
    }

    public void clicEmpresasGobierno() {
        clickJS(linkEmpresasGobierno);
    }

    public void clicMultinacionales() {
        clickJS(linkMultinacionales);
    }
}