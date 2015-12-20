package tests;

import UI.forms.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriver.BaseTest;


public class AutoBaraholkaSearchTest extends BaseTest {

   private int minPrice;
   private int maxPrice;
    private String manufacturer1;
    private String manufacturer2;
    private int minYear;
    private int maxYear;
    private int maxMileage;

    @Test
    @Parameters({"minAutoPrice", "maxAutoPrice", "manufacturerAuto1", "manufacturerAuto2", "minAutoYear", "maxAutoYear", "maxMileage"})
    public void readParams(int minAutoPrice, int maxAutoPrice, String manufacturerAuto1, String manufacturerAuto2, int minAutoYear, int maxAutoYear, int maxMileage) throws Throwable{
        this.minPrice = minAutoPrice;
        this.maxPrice = maxAutoPrice;
        this.manufacturer1 = manufacturerAuto1;
        this.manufacturer2 = manufacturerAuto2;
        this.minYear=minAutoYear;
        this.maxYear=maxAutoYear;
        this.maxMileage=maxMileage;
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
        mainForm.getMainMenu().goToAutoBaraholka();
        AutoBaraholkaForm autoBaraholkaForm = new AutoBaraholkaForm();

        logger.step(3);
        autoBaraholkaForm.setPriceMin(minPrice);
        autoBaraholkaForm.setPriceMax(maxPrice);
        autoBaraholkaForm.setManufacturer(manufacturer1);
        autoBaraholkaForm.setYearMin(minYear);
        autoBaraholkaForm.setYearMax(maxYear);
        autoBaraholkaForm.setMaxMileage(maxMileage);

        logger.step(4);
        autoBaraholkaForm.assertSearchResults(manufacturer1, minPrice, maxPrice, minYear, maxYear, maxMileage);

        logger.step(5);
        autoBaraholkaForm.setManufacturer(manufacturer2);

        logger.step(6);
        autoBaraholkaForm.assertSearchResults(manufacturer2, minPrice, maxPrice, minYear, maxYear, maxMileage);
    }
}
