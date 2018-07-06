package com.aplana.autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewSerpPage extends PageBase {

    private static final By mainHeader = By.xpath("//h1");
    private static final By nameFirstProductInPage = By.xpath("//*[contains(@class, 'n-snippet-list ')]/div[1]//div[contains(@class, 'title')]//a");

    public NewSerpPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNameFirstProductInPage() {
        try{
            return driver.findElement(nameFirstProductInPage).getText();
        }
        catch (Exception e) {
            return driver.findElement(mainHeader).getText();
        }
    }
}
