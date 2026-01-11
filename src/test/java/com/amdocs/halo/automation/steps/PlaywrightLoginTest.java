package com.amdocs.halo.automation.steps;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amdocs.halo.automation.base.PlaywrightTest;

public class PlaywrightLoginTest extends PlaywrightTest {

    @Test
    public void verifyLoginPageTitle()
    {

        try 
        {
            page.get().navigate("https://the-internet.herokuapp.com/login");

            String title = page.get().title();
            System.out.println("Page Title: " + title);

            Assert.assertTrue(title.contains("The Internet"));

        } 
        catch (Exception e) 
        {
                    System.err.println("An error occurred during operations: " + e.getMessage());
                    // Handle exceptions gracefully, potentially taking a screenshot
        } 
    }

    @Test
    public void loginWithValidCredentials() 
    {

        try 
        {
            page.get().navigate("https://the-internet.herokuapp.com/login");

            page.get().locator("#username").fill("tomsmith");
            page.get().locator("#password").fill("SuperSecretPassword!");
            page.get().locator("button[type='submit']").click();

            String successMessage = page.get().locator("#flash").textContent();
            System.out.println(successMessage);

            Assert.assertTrue(successMessage.contains("You logged into a secure area!"));
        
        } 
        catch (Exception e) 
        {
                    System.err.println("An error occurred during operations: " + e.getMessage());
                    // Handle exceptions gracefully, potentially taking a screenshot
        } 
    }   
}
