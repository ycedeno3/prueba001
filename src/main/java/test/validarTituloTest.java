package test;

import Page.Prueba_Netflix;
import org.testng.Assert;
import org.testng.annotations.Test;

public class validarTituloTest extends Prueba_Netflix {
    @Test
    public void validarTitulo() throws InterruptedException {
        String tituloEsperado;
        tituloEsperado = "Netflix Chile: Ve series online, ve películas online";
        String tituloActual = "";
        tituloActual = driver.getTitle();
        System.out.println(tituloActual);
        Assert.assertEquals(driver.getTitle(),
                tituloEsperado,
                tituloActual);
    }
}