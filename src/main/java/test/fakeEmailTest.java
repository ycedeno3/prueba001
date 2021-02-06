package test;

import Page.Prueba_Netflix;
import Page.fakerClass;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Utilities;

public class fakeEmailTest extends Prueba_Netflix {

    @Test
    public void fakeEmail() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id = 'id_email_hero_fuji']")).click();
        driver.findElement(By.xpath("//input[@id = 'id_email_hero_fuji']")).sendKeys(fakerClass.devuelveMailAleatorio());
        driver.findElement(By.xpath("//span[@class = 'cta-btn-txt']")).click();
        Utilities.waitXseconds(3);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertTrue(url.contains("signup"),"signup");
    }
}