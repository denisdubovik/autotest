package com.aplana.autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketPage extends PageBase {

    private static final By sectionElectronics = By.xpath("//a[contains(@href, '54440')]");
    private static final By tv = By.xpath("//a[contains(@href, '59601')]");
    private static final By headphones = By.xpath("//a[contains(@href, '56179')]");
    private static final By headerSearch = By.xpath("//*[@id='header-search']");
    private static final By returnButton = By.xpath("//span[text()='Вернуться на Маркет']/..");

    public MarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cleanMarketPage(){

        try {
            driver.findElement(returnButton).click();
        }
        catch (Exception e){
        }
        finally {
            driver.findElement(headerSearch).click();
        }

    }

    public void goToElectronicsTV(){

        WebElement mainMenu = driver.findElement(sectionElectronics);
        WebElement subMenu = driver.findElement(tv);

        Actions builder = new Actions(driver);
        builder.moveToElement(mainMenu).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(subMenu));
        builder.moveToElement(subMenu).click(subMenu).build().perform();
    }

    public void goToElectronicsHeadphones(){
        WebElement mainMenu = driver.findElement(sectionElectronics);
        WebElement subMenu = driver.findElement(headphones);

        Actions builder = new Actions(driver);
        builder.moveToElement(mainMenu).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(subMenu));
        builder.moveToElement(subMenu).click(subMenu).build().perform();
    }
}
