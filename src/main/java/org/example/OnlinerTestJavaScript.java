package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OnlinerTestJavaScript extends BaseTestForOnliner {
    @Test
    public void jsTest() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        WebElement element = driver.findElement(By.xpath("//a[contains (text(),'Люди')]"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);", element);
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight);", element);
    }
}
