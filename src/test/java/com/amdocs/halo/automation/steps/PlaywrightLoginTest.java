package com.amdocs.halo.automation.steps;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amdocs.halo.automation.base.PlaywrightTest;

public class PlaywrightLoginTest extends PlaywrightTest {

    @Test
    public void verifyLoginPageTitle() {

        try {
        page.navigate("https://the-internet.herokuapp.com/login");

        String title = page.title();
        System.out.println("Page Title: " + title);

        Assert.assertTrue(title.contains("The Internet"));

        } catch (Exception e) {
                System.err.println("An error occurred during operations: " + e.getMessage());
                // Handle exceptions gracefully, potentially taking a screenshot
            } finally {
                // Ensure the browser and context are closed
                if (browser != null) {
                    browser.close();
                }}
    }

    @Test
    public void loginWithValidCredentials() {

        try {
        page.navigate("https://the-internet.herokuapp.com/login");

        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator("button[type='submit']").click();

        String successMessage = page.locator("#flash").textContent();

        Assert.assertTrue(successMessage.contains("You logged into a secure area!"));
    
    } catch (Exception e) {
                System.err.println("An error occurred during operations: " + e.getMessage());
                // Handle exceptions gracefully, potentially taking a screenshot
            } finally {
                // Ensure the browser and context are closed
                if (browser != null) {
                    browser.close();
                }}
}
