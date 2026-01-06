package com.amdocs.halo.automation.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.PlaywrightException;

public class PlaywrightTest {
 protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeMethod
    public void setUp() {
        try (Playwright playwright = Playwright.create()) {

        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(500)
        );

        context = browser.newContext();
        page = context.newPage();}
        catch (PlaywrightException pe) {
            System.err.println("Playwright initialization error: " + pe.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        context.close();
        browser.close();
        playwright.close();
    }
}
