package com.aplana.autotest;

import com.aplana.autotest.pages.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static com.aplana.autotest.CustomDriver.createChromeDriver;
import static java.lang.String.format;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class YandexSearchTest {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = createChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.goToMarket();
    }

    @Test
    void searchForTV(){

        MarketPage marketPage = new MarketPage(driver);
        marketPage.cleanMarketPage();
        marketPage.goToElectronicsTV();

        ProductPage productPage= new ProductPage(driver);
        productPage.setSize();
        productPage.selectFiltersTV();
    }

   @Test
    void searchForHeadphones(){

        MarketPage marketPage = new MarketPage(driver);
        marketPage.cleanMarketPage();
        marketPage.goToElectronicsHeadphones();

        ProductPage productPage= new ProductPage(driver);
        productPage.setSize();
        productPage.selectFiltersHeadphones();
    }

    @AfterMethod
    public void tearDown() {

        ProductPage productPage= new ProductPage(driver);
        assertTrue(productPage.isOfCorrectSize());
        String nameFirstProductInProductPage = productPage.getNameFirstProductInPage();
        productPage.goToSearch();

        NewSerpPage newSerpPage = new NewSerpPage(driver);
        assertEquals(nameFirstProductInProductPage, newSerpPage.getNameFirstProductInPage(), format("Критерий поиска не соответствует названию товара: ожидалось [%s], фактическое значение: [%s]", nameFirstProductInProductPage, newSerpPage.getNameFirstProductInPage()));

        driver.quit();
    }

}


