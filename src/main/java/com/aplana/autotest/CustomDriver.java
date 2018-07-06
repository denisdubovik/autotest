package com.aplana.autotest;

import org.openqa.selenium.chrome.ChromeDriver;

public class CustomDriver {

    public static ChromeDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", CustomDriver.class.getClassLoader().getResource("chromedriver.exe").getFile());
        return new ChromeDriver();
    }
}
