package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OnlinerTest extends BaseTestForOnliner {
    @Test
    public void checkFindProductOnIFrame() {
        driver.findElement(By.xpath("//input[@class='fast-search__input']")).sendKeys("Lego");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class = 'modal-iframe']")));
        String text;
        text = driver.findElement(By.xpath("//ul[@class='search__results']//li[2]/div/div/div[2]/div/a")).getText();
        driver.findElement(By.xpath("//input[@class='search__input']")).clear();
        driver.findElement(By.xpath("//input[@class='search__input']")).sendKeys(text);
        driver.findElement(By.xpath("//span[@class='search__close']")).click();
        String textAfterFind;
        textAfterFind = driver.findElement(By.xpath("//span[@class='text_match']")).getText();
        Assert.assertEquals(text, textAfterFind, "Text not equal");
    }
}
