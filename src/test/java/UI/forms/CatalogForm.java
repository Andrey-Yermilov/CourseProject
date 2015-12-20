package UI.forms;

import org.openqa.selenium.By;
import webdriver.BaseForm;
import webdriver.Translit;
import webdriver.elements.Label;

/**
 * Форма каталога
 */
public class CatalogForm extends BaseForm {
    private static final String formLocator = "//li[@class='b-main-navigation__item b-main-navigation__item-active']/a[contains(text(),'Каталог')]";
    private String categoryTemplate = "//span[contains(text(),'%s')]";
    private String sectionTemplate = "//span[@class = 'catalog-navigation-list__link-inner']/a[text()='%s']";
    private Label lblCategory;
    private Label lblSection;

    public CatalogForm() {
        super(By.xpath(formLocator), "Catalog Onliner");
    }

    /**
     * Открыть субменю
     * @param category категория субменю
     */
    public void openSubMenu (String category){
        String categoryEn = Translit.toTranslit(category);
        lblCategory = new Label(By.xpath(String.format(categoryTemplate, category)),String.format("%s", categoryEn));
        lblCategory.click();
    }

    /**
     * Перейти в конкрутный раздел
     * @param section раздел
     */
    public void openSection (String section){
        String sectionEn = Translit.toTranslit(section);
        lblSection = new Label(By.xpath(String.format(sectionTemplate, section)),String.format("%s", sectionEn));
        lblSection.click();
    }
}

