package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.GetProperties;
import utilities.Utilities;

public class validarTitutloTest2 {
    @Test
    public void prueba_netflix() {
        GetProperties properties = new GetProperties();
        String chromeDriverURL = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Connectis\\Documents\\Finanzas\\chromedriver_win32\\chromedriver(2).exe");
        WebDriver driver = new ChromeDriver();
        String baseURL = "https://www.netflix.com/";
        driver.get(baseURL);
        driver.manage().window().maximize();
        System.out.println("Maximizando pantalla....!!!");
        System.out.println("----------");
        Utilities.waitXseconds(3);
        String tituloEsperado;
        tituloEsperado = "Netflix Chile: Ve series online, ve películas online";
        String tituloActual = "";
        tituloActual = driver.getTitle();
        System.out.println(tituloActual);
        Assert.assertEquals(driver.getTitle(),
                tituloEsperado,
                tituloActual);
        driver.quit();
    }

    @Test
    public void iniciarSesionPageTest() {
        GetProperties properties = new GetProperties();
        String chromeDriverURL = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Connectis\\Documents\\Finanzas\\chromedriver_win32\\chromedriver(2).exe");
        WebDriver driver = new ChromeDriver();
        String baseURL = "https://www.netflix.com/";
        driver.get(baseURL);
        driver.manage().window().maximize();
        System.out.println("Maximizando pantalla....!!!");
        System.out.println("----------");
        Utilities.waitXseconds(3);
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
        if (driver.findElement(By.xpath("//span[contains(text(),'Iniciar sesión con Facebook')]")).isDisplayed()) {
            System.out.println("El elemento Iniciar sesión Facebook se encuentra presente!!");
        } else {
            System.out.println("No se encutnra el elemento Iniciar sesió Facebook");
        }
        driver.quit();
    }

    @Test
    public void loginToNetflixErrorTest() {
        GetProperties properties = new GetProperties();
        String chromeDriverURL = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Connectis\\Documents\\Finanzas\\chromedriver_win32\\chromedriver(2).exe");
        WebDriver driver = new ChromeDriver();
        String baseURL = "https://www.netflix.com/";
        driver.get(baseURL);
        driver.manage().window().maximize();
        System.out.println("Maximizando pantalla....!!!");
        System.out.println("----------");
        Utilities.waitXseconds(3);
        driver.findElement(By.xpath("//a[contains(text(),'Iniciar sesión')]")).click();
        driver.findElement(By.name("userLoginId")).sendKeys("ycedeno363@gmail.com");
        driver.findElement(By.name("password")).sendKeys("holaMundo");
        // driver.findElement(By.xpath("//input[@id = 'bxid_rememberMe_true']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Iniciar sesión')]")).click();
        Utilities.waitXseconds(5);
        String mensaje = "No podemos encontrar una cuenta con esta dirección de email. Reinténtalo o ";
        System.out.println("impirmiendoeeeee e" + driver.findElement(By.xpath("//input[@id = 'bxid_rememberMe_true']")).getText());
        String tituloActual = "No se encontro mensaje de contraseñ incorrecta";
        //  Assert.assertEquals(driver.findElement(driver.findElement(By.name("password")).sendKeys("holaMundo");.
        //getText(),
        //        mensaje,
        //      tituloActual);
        driver.quit();
    }

    @Test
    public void fakeEmailTest() {
        GetProperties properties = new GetProperties();
        String chromeDriverURL = properties.getString("CHROMEDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Connectis\\Documents\\Finanzas\\chromedriver_win32\\chromedriver(2).exe");
        WebDriver driver = new ChromeDriver();
        String baseURL = "https://www.netflix.com/";
        driver.get(baseURL);
        driver.manage().window().maximize();
        System.out.println("Maximizando pantalla....!!!");
        System.out.println("----------");
        Utilities.waitXseconds(3);
        driver.findElement(By.xpath("//input[@id = 'id_email_hero_fuji']")).click();
        driver.findElement(By.xpath("//input[@id = 'id_email_hero_fuji']")).sendKeys(fakers.fakerClass.devuelveMailAleatorio());
        driver.findElement(By.xpath("//span[@class = 'cta-btn-txt']")).click();
        driver.getCurrentUrl();
        String tituloEsperado;
        tituloEsperado = "https://www.netflix.com/signup/registration?locale=es-CL";
        String tituloActual = "";
        tituloActual = driver.getTitle();
        System.out.println(tituloActual);
        Assert.assertEquals(driver.getTitle(),
                tituloEsperado,
                tituloActual);
        driver.quit();
    }
}