package com.amdocs.halo.automation.steps;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amdocs.halo.automation.base.PlaywrightTest;

public class PlaywrightLoginTest extends PlaywrightTest {

    @Test
    public void verifyLoginPageTitle() {

        page.navigate("https://the-internet.herokuapp.com/login");

        String title = page.title();
        System.out.println("Page Title: " + title);

        Assert.assertTrue(title.contains("The Internet"));
    }

    @Test
    public void loginWithValidCredentials() {

        page.navigate("https://the-internet.herokuapp.com/login");

        page.locator("#username").fill("tomsmith");
        page.locator("#password").fill("SuperSecretPassword!");
        page.locator("button[type='submit']").click();

        String successMessage = page.locator("#flash").textContent();

        Assert.assertTrue(successMessage.contains("You logged into a secure area!"));
    }
}
