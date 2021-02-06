package test;

import Page.DataProvidersClass;
import Page.Prueba_Netflix;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.Utilities;

public class dataProviderEmailTest extends Prueba_Netflix {

    @Test(dataProvider = "correos", dataProviderClass = DataProvidersClass.class)
    public void fakeEmail(String correos) {
            driver.findElement(By.xpath("//input[@id = 'id_email_hero_fuji']")).clear();
            driver.findElement(By.xpath("//input[@id = 'id_email_hero_fuji']")).click();
            driver.findElement(By.xpath("//input[@id = 'id_email_hero_fuji']")).sendKeys(correos);
            driver.findElement(By.xpath("//span[@class = 'cta-btn-txt']")).click();
            Utilities.waitXseconds(3);
            driver.findElement(By.id("netflix-logo")).click();
            Utilities.waitXseconds(3);
    }
}