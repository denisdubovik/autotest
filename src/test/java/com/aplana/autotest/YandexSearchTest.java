package com.aplana.autotest;

import com.aplana.autotest.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.aplana.autotest.CustomDriver.createChromeDriver;
import static com.aplana.autotest.CustomDriver.createGeckoDriver;
import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class YandexSearchTest {

    private WebDriver driver;
    @Parameters ("browser")
    @BeforeMethod
    public void getDriver(String browser) {
        if(browser.equals("chrome")) {
            driver = createChromeDriver();
        }
        else if(browser.equals("firefox")) {
            driver = createGeckoDriver();
        }
        driver.manage().window().maximize();

    }

   // @BeforeMethod
   // public void setup(){
    //}

    @Test (priority = 0, enabled = false)
    void searchForTV(){
        driver.get("https://www.yandex.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMarket();
        MarketPage marketPage = new MarketPage(driver);
        marketPage.cleanMarketPage();
        marketPage.goToElectronicsTV();

        ProductPage productPage= new ProductPage(driver);
        productPage.setSize();
        productPage.selectFiltersTV();
        assertTrue(productPage.isOfCorrectSize());
        String nameFirstProductInProductPage = productPage.getNameFirstProductInPage();
        productPage.goToSearch();

        NewSerpPage newSerpPage = new NewSerpPage(driver);
        assertEquals(newSerpPage.getNameFirstProductInPage(), nameFirstProductInProductPage, format("Критерий поиска не соответствует названию товара: фактическое значение [%s], ожидалось: [%s]", newSerpPage.getNameFirstProductInPage(), nameFirstProductInProductPage));
    }

   @Test (priority = 1, enabled = false)
    void searchForHeadphones(){
        driver.get("https://www.yandex.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMarket();
        MarketPage marketPage = new MarketPage(driver);
        marketPage.cleanMarketPage();
        marketPage.goToElectronicsHeadphones();

        ProductPage productPage= new ProductPage(driver);
        productPage.setSize();
        productPage.selectFiltersHeadphones();
        assertTrue(productPage.isOfCorrectSize());
        String nameFirstProductInProductPage = productPage.getNameFirstProductInPage();
        productPage.goToSearch();

        NewSerpPage newSerpPage = new NewSerpPage(driver);
        assertEquals(newSerpPage.getNameFirstProductInPage(), nameFirstProductInProductPage, format("Критерий поиска не соответствует названию товара: фактическое значение [%s], ожидалось: [%s]", newSerpPage.getNameFirstProductInPage(), nameFirstProductInProductPage));
   }

    @Test (priority = 0)
    void headerTV() {
        driver.get("https://www.yandex.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMarket();
        MarketPage marketPage = new MarketPage(driver);
        marketPage.cleanMarketPage();
        marketPage.goToElectronicsTV();
        assertEquals(driver.getTitle(), ProductPage.HEADERTV, format("Критерий поиска не соответствует названию товара: фактическое значение [%s], ожидалось: [%s]", driver.getTitle(), ProductPage.HEADERTV));

    }

    @Test (priority = 1)
    void headerHeadphones() {
        driver.get("https://www.yandex.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMarket();
        MarketPage marketPage = new MarketPage(driver);
        marketPage.cleanMarketPage();
        marketPage.goToElectronicsHeadphones();
        assertEquals(driver.getTitle(), ProductPage.HEADERHEADPHONES, format("Критерий поиска не соответствует названию товара: фактическое значение [%s], ожидалось: [%s]", driver.getTitle(), ProductPage.HEADERHEADPHONES));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}


