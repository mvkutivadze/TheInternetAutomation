package org.example;

import org.example.pages.AddRemoveElementsPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainTest {

    private WebDriver driver;
    private MainPage mainPage;


    @Before
    public void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options); //создание экземпляра драйвера
        mainPage = new MainPage(driver);
        driver.manage().window().maximize(); //окно разворачивается на полный экран
    }

    @AfterEach
    public void afterEach() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void followLink() {
        driver.get(ConfProperties.getProperty("page"));
        mainPage.clickABTestingLink();
    }

    @Test
    public void addRemoveElements() {
        driver.get(ConfProperties.getProperty("page"));
        mainPage.clickAddRemoveLink();
        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage(driver);
        addRemoveElementsPage.clickAddElementBtn();
        addRemoveElementsPage.clickDeleteBtn();
    }

}
