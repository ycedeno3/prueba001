package test;

import Page.Prueba_Netflix;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Utilities;

public class loginToNetflixErrorTest extends Prueba_Netflix {

    @Test
    public void loginToNetflixError() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Iniciar sesión')]")).click();
        driver.findElement(By.name("userLoginId")).sendKeys("ycedeno363@gmail.com");
        driver.findElement(By.name("password")).sendKeys("holaMundo");
        driver.findElement(By.xpath("//span[@class = 'login-remember-me-label-text']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Iniciar sesión')]")).click();
        Utilities.waitXseconds(5);
        String mensaje = driver.findElement(By.xpath("//div[@class = 'ui-message-contents']")).getText();
        Assert.assertEquals("No podemos encontrar una cuenta con esta dirección de email. Reinténtalo o crea una cuenta nueva.", mensaje);
        if (driver.findElement(By.xpath("//span[@class = 'login-remember-me-label-text']")).isSelected()) {
            System.out.println("El chekbox No esta seleccionado");
        } else {
            System.out.println("El checkbox esta seleccionado");
        }
    }
}