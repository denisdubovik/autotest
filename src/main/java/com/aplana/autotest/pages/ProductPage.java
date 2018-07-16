package com.aplana.autotest.pages;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends PageBase {

    private static final int sizeElement = 12;
    public static final String lowPriseTV = "20000", lowPriseHeadphones = "5000", HEADERTV="Телевизоры — купить на Яндекс.Маркете", HEADERHEADPHONES="Наушники и Bluetooth-гарнитуры — купить на Яндекс.Маркете";
    private static final By lowPrise = By.xpath("//input[@id='glpricefrom']");
    private static final By makerSamsung = By.xpath("//input[@id='7893318_153061']");
    private static final By makerLG = By.xpath("//input[@id='7893318_153074']");
    private static final By makerBeats = By.xpath("//input[@id='7893318_8455647']");
    private static final By size48 = By.xpath("//span[text()='Показывать по 48']/..");
    private static final By size12 = By.xpath("//span[text()='Показывать по 12']/..");
    private static final By sameModel = By.xpath("//*[contains(@data-id, 'model-')]");
    private static final By nameFirstProductInPagee = By.xpath("//*[contains(@class, 'n-snippet-list ')]/div[1]//div[contains(@class, 'title')]//a");
    private static final By headerSearch = By.xpath("//*[@id='header-search']");
    private static final By completedRefreshSerp = By.xpath("//div[contains(@class, 'n-filter-applied-results ')]/div[@style='height: auto;']");
    private static final By processRefreshSerp = By.xpath("//div[contains(@class, 'n-filter-applied-results ')]/div[@style!='height: auto;']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSize(){
        driver.findElement(size48).click();
        driver.findElement(size12).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(completedRefreshSerp));
    }

    public void selectFiltersTV(){
        driver.findElement(lowPrise).sendKeys(lowPriseTV);
        driver.findElement(makerSamsung).sendKeys(" ");
        driver.findElement(makerLG).sendKeys(" ");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(processRefreshSerp));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(completedRefreshSerp));
    }

    public void selectFiltersHeadphones(){
        driver.findElement(lowPrise).sendKeys(lowPriseHeadphones);
        driver.findElement(makerBeats).sendKeys(" ");
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(processRefreshSerp));
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(completedRefreshSerp));
    }

    public Boolean isOfCorrectSize(){
        return driver.findElements(sameModel).size() == sizeElement;
    }

    public String getNameFirstProductInPage(){
        return driver.findElement(nameFirstProductInPagee).getText();
    }

    public void goToSearch() {
        driver.findElement(headerSearch).sendKeys(getNameFirstProductInPage());
        driver.findElement(headerSearch).submit();
    }


}
