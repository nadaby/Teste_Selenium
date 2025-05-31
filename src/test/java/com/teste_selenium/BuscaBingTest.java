package com.teste_selenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BuscaBingTest {

    @Test
    public void testeBuscaBing() {

        System.setProperty("webdriver.edge.driver",
                "C:\\Users\\felip\\Downloads\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        try {
            driver.get("https://www.bing.com/?cc=br");
            driver.manage().window().maximize();

            WebElement campoBusca = driver.findElement(By.name("q"));
            campoBusca.sendKeys("Hello World");
            campoBusca.submit();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("b_results")));

            System.out.println("Busca realizada com sucesso!");

        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante o teste: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
