package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextContentCheck {

    private WebDriver driver;

    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Test //this test is to learn of checking content
    public void checkContent() {

        String url = "https://the-internet.herokuapp.com/abtest";
        driver.get(url);
        String actualString = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
        assertTrue(actualString.contains("A/B Test Variation 1"));
    }

}
