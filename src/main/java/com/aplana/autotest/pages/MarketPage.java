package com.aplana.autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketPage extends PageBase {

    private static final By sectionElectronics = By.xpath("//li[@data-department='Электроника']");
    private static final By tv = By.xpath("//a[contains(@href, '59601')]");
    private static final By headphones = By.xpath("//a[contains(@class, 'topmenu__subitem_nid_56179')]");
    private static final By headerSearch = By.xpath("//*[@id='header-search']");

    public MarketPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToElectronicsTV(){
        WebElement mainMenu = driver.findElement(sectionElectronics);
        WebElement subMenu = driver.findElement(tv);

        driver.findElement(headerSearch).click();
        Actions builder = new Actions(driver);
        builder.moveToElement(mainMenu).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(subMenu));
        builder.moveToElement(subMenu).click(subMenu).build().perform();
    }

    public void goToElectronicsHeadphones(){
        WebElement mainMenu = driver.findElement(sectionElectronics);
        WebElement subMenu = driver.findElement(headphones);

        driver.findElement(headerSearch).click();
        Actions builder = new Actions(driver);
        builder.moveToElement(mainMenu).build().perform();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(subMenu));
        builder.moveToElement(subMenu).click(subMenu).build().perform();
    }
}
