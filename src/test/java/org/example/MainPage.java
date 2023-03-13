package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[contains(text(), 'A/B Testing')]")
    private WebElement ABTestingLink;

    public void clickABTestingLink() {
        ABTestingLink.click(); }

    @FindBy(xpath = "//*[contains(text(), 'Add/Remove Elements')]")
    private WebElement AddRemoveLink;

    public void clickAddRemoveLink() {
        AddRemoveLink.click(); }
}