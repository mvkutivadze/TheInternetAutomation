package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddRemoveElementsTest {

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

    @Test // this test is to learn of clicking on elements
    public void addRemoveElements() {
        String url = "https://the-internet.herokuapp.com/add_remove_elements/";
        driver.get(url);

        WebElement addBtn = driver.findElement(By.xpath("//*[contains(text(), 'Add Element')]"));
        addBtn.click();

        WebElement deleteBtn = driver.findElement(By.xpath("//*[contains(text(), 'Delete')]"));
        deleteBtn.click();

    }
}
