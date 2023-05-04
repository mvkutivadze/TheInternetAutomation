package org.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.http.impl.client.HttpClientBuilder;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class BrokenImagesTest {

    private WebDriver driver;
    private int invalidImageCount;

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

    @Test //this tests checks if there are broken images (response status not 200) and counts their number
    public void checkImage() throws IOException {
        String url = "https://the-internet.herokuapp.com/broken_images";
        driver.get(url);


        invalidImageCount = 0;
        List<WebElement> imagesList = driver.findElements(By.tagName("img"));

        Assert.assertEquals(4, imagesList.size());
        for (WebElement imgElement : imagesList) {
            if (imgElement != null) {
                verifyImageActive(imgElement);
            }
        }

        Assert.assertEquals(0, invalidImageCount);
    }

    private void verifyImageActive(WebElement imgElement) throws IOException {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(imgElement.getAttribute("src"));

        System.out.println("OLOLO " + request.toString());
        HttpResponse response = client.execute(request);
        if (response.getStatusLine().getStatusCode() != 200) {
            invalidImageCount++;
        }
    }

}
