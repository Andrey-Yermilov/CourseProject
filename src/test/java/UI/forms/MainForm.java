package UI.forms;

import UI.menu.LoginMenu;
import UI.menu.MainMenu;
import org.openqa.selenium.By;
import org.testng.Assert;
import webdriver.BaseForm;
import webdriver.elements.Button;
import webdriver.elements.Label;
import webdriver.elements.TextBox;

/**
 * Главная страница сайта onliner
 */
public class MainForm extends  BaseForm {
    private static final String formLocator = "//div[contains(@class,'main-page-grid')]";
    private Label lblUsername;
    private Label lblBookmarks;
    private Label lblExit;
    private Label lblCurrency = new Label(By.id("currency-informer"), "Currencies");
    private Button btnAllOffers = new Button(By.xpath("//a[@class='button button_orange product__button']"),"All Offers");
    private TextBox txbSearch = new TextBox(By.xpath("//input[@class='fast-search__input']"),"Search");
    private MainMenu mainMenu = new MainMenu();
    private LoginMenu loginMenu = new LoginMenu();

    public MainForm() {
        super(By.xpath(formLocator), "Onliner main");
    }

    /**
     * Геттер для главного меню
     * @return главное меню
     */
    public MainMenu getMainMenu() {
        return mainMenu;
    }

    /**
     * Геттер для меню логина
     * @return меню логина
     */
    public LoginMenu getLoginMenu() {
        return loginMenu;
    }

    /**
     * Перейти на форму профиля пользователя
     */
    public void goToProfileForm() {
        Label lblUserName = new Label(By.xpath("//p[@class='user-name']/a"), "Usermane");
        lblUserName.click();
    }

    /**
     * Перейти на старницу валют
     */
    public void goToCurrencyForm() {
        lblCurrency.click();
    }

    /**
     * Выйти
     */
    public void exit(){
        lblExit = new Label(By.xpath("//a[@class='exit']"), "Exit");
        lblExit.click();
    }

    /**
     * Проверить,ч то пользователь залогинен
     * @param expectedUsername имя пользователя
     */
    public void assertLoggedIn(String expectedUsername) {
        lblUsername = new Label(By.xpath("//p[@class='user-name']/a"), "User name");
        String actualLogin = lblUsername.getText();
        info(String.format("Username: Expected %s, found %s", expectedUsername, actualLogin));
        Assert.assertTrue(actualLogin.contains(expectedUsername));
    }

    /**
     * Перейти на форму закладок пользователя
     */
    public void goToBookmarks(){
        lblBookmarks = new Label(By.xpath("//a[text()='Закладки']"),"Bookmarks");
        lblBookmarks.click();
    }

    /**
     * Осуществить поиск
     * @param request поисковой запрос
     */
    public void performFastSearch (String request){
        txbSearch.setText(request);
        switchToModalFrame("modal-iframe");
    }

    /**
     * Перейти к предложениям продавцов
     */
    public void viewOffers (){
        btnAllOffers.click();
        switchToMainFrame();
    }
}