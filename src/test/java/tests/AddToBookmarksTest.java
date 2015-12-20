package tests;

import UI.forms.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;
import java.io.FileInputStream;

public class AddToBookmarksTest extends BaseTest {

    private String typeOfLogin;
    private String username;
    private String currentPassword;
    private String bookmarksTab;
    private String mainMenuTab ;
    private String category ;
    private String sectionForAddToBookmarksTest;
    private int itemNumber = 1;

    @Test
    @Parameters({ "typeOfLogin", "username", "passwordPath", "bookmarksTab","mainMenuTab", "category", "sectionForAddToBookmarksTest"})
    public void readParams(String typeOfLogin, String username, String passwordPath, String bookmarksTab, String mainMenuTab, String category, String sectionForAddToBookmarksTest) throws Throwable{
        this.typeOfLogin = typeOfLogin;
        this.username = username;
        this.bookmarksTab = bookmarksTab;
        this.mainMenuTab = mainMenuTab;
        this.category = category;
        this.sectionForAddToBookmarksTest = sectionForAddToBookmarksTest;
        FileInputStream fileInputStream = new FileInputStream(passwordPath);
        byte[] tmp = new byte[12];
        fileInputStream.read(tmp);
        this.currentPassword = new String(tmp);
        xTest();
    }

    @Test (enabled = false)
    public void xTest() throws Throwable {
        super.xTest();
    }

    public void runTest() {
        logger.step(1);
        MainForm mainForm = new MainForm();

        logger.step(2);
        mainForm.getLoginMenu().openLoginForm(typeOfLogin);
        LoginForm loginForm = new LoginForm();
        loginForm.login(username, currentPassword);
        mainForm.assertLoggedIn(username);

        logger.step(3);
        mainForm.goToBookmarks();
        BookmarksForm bookmarksFormInitial = new BookmarksForm();
        bookmarksFormInitial.getBookmarksTypesMenu().openTab(bookmarksTab);
        bookmarksFormInitial.emptyBookmarks();

        logger.step(4);
        mainForm.getMainMenu().openTab(mainMenuTab);
        CatalogForm catalogForm = new CatalogForm();
        catalogForm.openSubMenu(category);
        catalogForm.openSection(sectionForAddToBookmarksTest);
        SectionForm sectionForm = new SectionForm();

        logger.step(5);
        sectionForm.goToItemForm(itemNumber);
        ItemForm itemForm = new ItemForm();
        String actualModel = itemForm.getFullItemName();

        logger.step(6);
        itemForm.addToBookmarks();
        itemForm.assertInBookmarks();

        logger.step(7);
        mainForm.goToBookmarks();
        BookmarksForm bookmarksForm = new BookmarksForm();
        bookmarksForm.getBookmarksTypesMenu().openTab(bookmarksTab);
        bookmarksForm.assertBookmarkInCatalog(itemNumber,actualModel);

        logger.step(8);
        bookmarksForm.emptyBookmarks();
    }
}


