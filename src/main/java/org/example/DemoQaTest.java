package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoQaTest extends BaseTestDemoQa {

    @Test
    public void checkAlertText() {
        driver.findElement(By.id("alertButton")).click();
        String textForTest = driver.switchTo().alert().getText();
        Assert.assertEquals(textForTest, "You clicked a button", "Mistake on text alert");
        driver.switchTo().alert().accept();
    }

    @Test
    public void checkAlertTextWithWait() {
        driver.findElement(By.id("timerAlertButton")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        String textForTest = driver.switchTo().alert().getText();
        Assert.assertEquals(textForTest, "This alert appeared after 5 seconds", "Mistake on alert with 5 sec wait");
        driver.switchTo().alert().accept();
    }

    @Test
    public void checkAlertSelected() {
        driver.findElement(By.id("confirmButton")).click();
        String textForTest = driver.switchTo().alert().getText();
        Assert.assertEquals(textForTest, "Do you confirm action?", "Mistake on text alert");
        driver.switchTo().alert().dismiss();
        String textForTest2 = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals(textForTest2, "You selected Cancel", "Mistake on text alert");
    }

    @Test
    public void checkInoutTextOnAlert() {
        String textForAlert = "Suvorov";
        driver.findElement(By.id("promtButton")).click();
        String textForTest = driver.switchTo().alert().getText();
        Assert.assertEquals(textForTest, "Please enter your name", "Mistake on text alert");
        driver.switchTo().alert().sendKeys(textForAlert);
        driver.switchTo().alert().accept();
        String textForTest2 = driver.findElement(By.id("promptResult")).getText();
        Assert.assertEquals("You entered " + textForAlert, textForTest2, "Mistake on text alert");
    }
}
