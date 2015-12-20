package UI.menu;

import org.openqa.selenium.By;
import webdriver.Translit;
import webdriver.elements.BaseElement;
import webdriver.elements.Label;

/**
 * Главное меню
 */
public class MainMenu extends BaseElement {
    private static final String menuLocator = "//ul[@class='onav__ul' or @class='b-main-navigation']";
   private String targetlinkTemplate = "//ul[@class='onav__ul' or @class='b-main-navigation']//a[text()='%s']";
    private Label lblAutoBaraholka = new Label(By.xpath("//ul[@class='onav__ul' or @class='b-main-navigation']//a[contains(text(),'Автобарахолка')]"), "Autobaraholka");

    public MainMenu() {
        super(By.xpath(menuLocator), "Main menu");
    }

    /**
     * ОТкрыть вкладку
     * @param menuLink ссылка
     */
    public void openTab(String menuLink) {
        String menuLinkEn = Translit.toTranslit(menuLink);
        Label lblMenuLink = new Label(By.xpath(String.format(targetlinkTemplate, menuLink)),String.format("%s", menuLinkEn));
        lblMenuLink.click();
    }

    /**
     * Открыть автобарахолку
     */
    public void goToAutoBaraholka(){
        lblAutoBaraholka.click();
    }
    protected String getElementType() {
        return getLoc("loc.menu");
    }
}
