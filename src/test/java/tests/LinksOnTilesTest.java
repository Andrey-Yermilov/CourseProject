package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;
import UI.forms.*;

public class LinksOnTilesTest extends BaseTest {

    private String mainMenuPeopleLink;
    private String mainMenuAutoLink;
    private String mainMenuTechLink;
    private String mainMenuRealtLink;


    @Test
    @Parameters({ "mainMenuPeopleLink", "mainMenuAutoLink", "mainMenuTechLink", "mainMenuRealtLink" })
    public void readParams(String mainMenuPeopleLink, String mainMenuAutoLink, String mainMenuTechLink, String mainMenuRealtLink) throws Throwable{
        this.mainMenuPeopleLink = mainMenuPeopleLink;
        this.mainMenuAutoLink = mainMenuAutoLink;
        this.mainMenuTechLink = mainMenuTechLink;
        this.mainMenuRealtLink = mainMenuRealtLink;

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
        mainForm.getMainMenu().openTab(mainMenuPeopleLink);
        PeopleForm peopleForm = new PeopleForm();

        logger.step(3);
        peopleForm.assertTilesLinks(mainMenuPeopleLink);

        logger.step(4);
        mainForm.getMainMenu().openTab(mainMenuAutoLink);
        AutoForm autoForm = new AutoForm();

        logger.step(5);
        autoForm.assertTilesLinks(mainMenuAutoLink);

        logger.step(6);
        mainForm.getMainMenu().openTab(mainMenuTechLink);
        TechForm techForm = new TechForm();

        logger.step(7);
        techForm.assertTilesLinks(mainMenuTechLink);

        logger.step(8);
        mainForm.getMainMenu().openTab(mainMenuRealtLink);
        RealtForm realtForm = new RealtForm();

        logger.step(9);
        realtForm.assertTilesLinks(mainMenuRealtLink);
    }
}


