package mavenforjenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UITest {

    @Parameters({"Browser", "Client"})
    @Test
    public void startBrowser(String browserName, String clientName) {
        System.out.println("Browser Parameter name is : " + browserName);
        System.out.println("Client Value name is : " + clientName);
        WebDriver driver = null;
        switch (browserName) {
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("INVALID BROWSER NAME: " + browserName);
        }
        driver.manage().window().maximize();
        if (clientName.equalsIgnoreCase("OrangeHRM")) {
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Title Mismatch ..");
        } else if (clientName.equalsIgnoreCase("BlazeDemo")) {
            driver.get("https://blazedemo.com/");
            Assert.assertEquals(driver.getTitle(), "BlazeDemo", "Title Mismatch ..");
        }
        driver.quit();
    }
}
