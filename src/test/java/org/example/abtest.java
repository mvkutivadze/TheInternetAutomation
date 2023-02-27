package org.example;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class abtest {
    public static MainPage mainPage;


    @Test
    public void followLink() {
        WebDriver driver = new ChromeDriver(); //создание экземпляра драйвера
        mainPage = new MainPage(driver);
        driver.manage().window().maximize(); //окно разворачивается на полный экран
        driver.get(ConfProperties.getProperty("page")); //получение ссылки на страницу из файла настроек
        mainPage.clickABTestingLink();
    }
}
