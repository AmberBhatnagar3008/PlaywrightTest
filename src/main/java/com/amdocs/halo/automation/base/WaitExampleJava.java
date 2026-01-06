package com.amdocs.halo.automation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitExampleJava {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().driverVersion("139.0.7258.157").clearDriverCache().setup();
        //WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("loginButton"))
        );

        loginButton.click();
        driver.quit();
    }
}
