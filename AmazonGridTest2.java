package assignmentDevops;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonGridTest2 {
    public WebDriver driver;

    @SuppressWarnings("deprecation")
    @Parameters({"browser"})
    @Test
    public void crossBrowserTesting(String browser) {
        try {
            

            // Setting up options for each browser and initializing RemoteWebDriver
            if (browser.equalsIgnoreCase("Chrome")) {
                ChromeOptions options = new ChromeOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                System.out.println("RemoteDriver connectivity is started");
                System.out.println("Session Created on Google Chrome");
                
            } else if (browser.equalsIgnoreCase("Firefox")) {
                FirefoxOptions options = new FirefoxOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                System.out.println("Session Created on Firefox");
               

            } else if (browser.equalsIgnoreCase("Edge")) {
                EdgeOptions options = new EdgeOptions();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
                System.out.println("Session Created on Edge");
                
            } else {
                System.out.println("Invalid Browser Parameter");
                return;  // Exit if browser parameter is invalid
            } 
                
                
            // Wait for the Amazon page to load
            Thread.sleep(10000);
            driver.get("https://www.amazon.in/");
            Thread.sleep(8000);;
            System.out.println("Page Title (" + browser + "): " + driver.getTitle());  
            // Output the page title on every browser
                
           
            

        } catch (MalformedURLException e) {
            System.out.println("URL is malformed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Ensure the driver quits after execution
            if (driver != null) {
              // driver.quit();
                System.out.println("Driver quit successfully for" + browser);
                
            }
        }
        
    }
    
}
            
        
    

