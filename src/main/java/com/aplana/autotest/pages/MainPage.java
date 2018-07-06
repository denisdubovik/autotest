package com.aplana.autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends PageBase {

    private static final By yandexMarket = By.xpath("//*[@data-id='market']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToMarket() {
        driver.findElement(yandexMarket).click();
    }
}
