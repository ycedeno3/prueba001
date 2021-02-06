package test;

import Page.Prueba_Netflix;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class inicioSessionPageTest extends Prueba_Netflix {

    @Test
    public void inicioSessionPage() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Iniciar sesión')]")).click();
        String tituloEsperado;
        tituloEsperado = "Netflix";
        String tituloAntiguo = "Netflix Chile: Ve series online, ve películas online";
        String tituloActual = "";
        tituloActual = driver.getTitle();
        System.out.println(tituloActual);
        Assert.assertEquals(driver.getTitle(),
                tituloEsperado,
                tituloActual);
        if (tituloActual != tituloAntiguo) {
            System.out.println("El titulo Antiguo: " + tituloAntiguo + ", No es igual al titulo Actual: " + tituloActual);
        } else {
            System.out.println("Los titulos de la pagina son iguales");
        }

        List<WebElement> listaDeH1s = driver.findElements(By.tagName("h1"));
        for (WebElement h1 : listaDeH1s) {
            if (h1.getText().equals("Inicia sesión")) {
                System.out.println("Exitse el elemento ");
            } else {
                System.out.println("No existe el elemento");
                Assert.fail();
            }
        }

        if (driver.findElement(By.xpath("//span[contains(text(),'Iniciar sesión con Facebook')]")).isDisplayed()) {
            System.out.println("El elemento Iniciar sesión Facebook se encuentra presente!!");
        } else {
            System.out.println("No se encuetra el elemento Iniciar sesión con Facebook");
        }
    }
}