package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicAuthTest {

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

    @Test // this test is to learn basic authentication
    public void basicAuth() {
        String username = "admin";
        String password = "admin";
        String url = "https://"+username+":"+password+"@the-internet.herokuapp.com/basic_auth";
        driver.get(url);

        String actualString = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p")).getText();
        assertTrue(actualString.contains("Congratulations! You must have the proper credentials."));
    }
}
