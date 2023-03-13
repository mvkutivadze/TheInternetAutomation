package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRemoveElementsPage {

    public WebDriver driver;

    public AddRemoveElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(text(), 'Add Element')]")
    public WebElement AddElementBtn;

    public void clickAddElementBtn() {
        AddElementBtn.click();
    }

    @FindBy(xpath = "//*[contains(text(), 'Delete')]")
    private static WebElement DeleteBtn;

    public void clickDeleteBtn() {
        DeleteBtn.click();
    }

}
