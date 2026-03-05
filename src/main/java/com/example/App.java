package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class App {
    public static void main(String[] args) {
        FirefoxOptions options = new FirefoxOptions();
        
        // Pointing to the internal Snap binary to prevent execution errors
        options.setBinary("/snap/firefox/current/usr/lib/firefox/firefox"); 
        
        // Headless mode is required for stable execution on VirtualBox
        //options.addArguments("--headless"); 

        WebDriver driver = new FirefoxDriver(options);

        try {
            System.out.println("Step 1: Logging into SauceDemo...");
            driver.get("https://www.saucedemo.com/");
            
            // Login credentials from your reference document
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            System.out.println("Login completed successfully.");

            // Step 2: Open a new blank tab
            System.out.println("Step 2: Opening a blank new tab...");
            driver.switchTo().newWindow(WindowType.TAB); 
            
            // Just staying on the blank tab as requested
            System.out.println("Current URL in new tab: " + driver.getCurrentUrl());

            // Short pause to ensure the tab is fully created
            Thread.sleep(2000); 

        } catch (Exception e) {
            System.out.println("Automation Error: " + e.getMessage());
        } finally {
            // Step 3: Close the browser session
            driver.quit();
            System.out.println("Browser closed. Automation finished.");
        }
    }
}
