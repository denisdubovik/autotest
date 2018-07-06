package com.aplana.autotest;

import com.aplana.autotest.pages.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.aplana.autotest.CustomDriver.createChromeDriver;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexSearchTest {

    private WebDriver driver;

    @BeforeEach
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
        marketPage.goToElectronicsTV();

        ProductPage productPage= new ProductPage(driver);
        productPage.setSize();
        productPage.selectFiltersTV();
    }

   @Test
    void searchForHeadphones(){

        MarketPage marketPage = new MarketPage(driver);
        marketPage.goToElectronicsHeadphones();

        ProductPage productPage= new ProductPage(driver);
        productPage.setSize();
        productPage.selectFiltersHeadphones();
    }

    @AfterEach
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


