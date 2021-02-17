package test;

import Page.Prueba_Netflix;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Scanner;

public class printTagsTest extends Prueba_Netflix {

    @Test
    public void printTags() {
        Scanner input = new Scanner(System.in);
        String tag;
        System.out.println("ingrese el tagName: ");
        tag = input.nextLine();
        List<WebElement> elementosLinks = driver.findElements(By.tagName(tag));
        System.out.println("-----------------------------Los elementos INPUT del sitio son: ");
        for (WebElement links : elementosLinks) {
            System.out.println(links.getText());
        }
    }
}