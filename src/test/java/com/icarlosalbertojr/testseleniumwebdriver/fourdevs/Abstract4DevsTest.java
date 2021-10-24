package com.icarlosalbertojr.testseleniumwebdriver.fourdevs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Abstract4DevsTest {

    private static final String URL_4DEVS = "https://www.4devs.com.br";
    private WebDriver driver;

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL_4DEVS);
        driver.manage().window().maximize();
    }

    @AfterAll
    public void afterExecution(){
        driver.quit();
    }

    protected WebElement findElementByXPath(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

    protected void goToHomePage() {
        driver.get(URL_4DEVS);
    }

}
