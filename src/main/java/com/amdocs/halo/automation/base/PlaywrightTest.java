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
    protected ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    protected ThreadLocal<Browser> browser = new ThreadLocal<>();
    protected ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    protected ThreadLocal<Page> page = new ThreadLocal<>();
    

    @BeforeMethod
    public void setUp() {
        try{
            playwright.set(Playwright.create());
            browser.set(playwright.get().chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(true)
                        .setSlowMo(500))
        );

        context.set(browser.get().newContext());
        page.set(context.get().newPage());
        }
        catch (PlaywrightException pe) {
            System.err.println("Playwright initialization error: " + pe.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (page != null) {
            try {
                page.get().close();
            } catch (Exception ignored) {
            }
            page = null;
        }
        if (context != null) {
            try {
                context.get().close();
            } catch (Exception ignored) {
            }
            context = null;
        }
        if (browser != null) {
            try {
                browser.get().close();
            } catch (Exception ignored) {
            }
            browser = null;
        }
        if (playwright != null) {
            try {
                playwright.get().close();
            } catch (Exception ignored) {
            }
            playwright = null;
        }
    }
}
