package loginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class loginpage {
    WebDriver driver;

    @Given("user is on the login page")
    public void launch_the_browser(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @When("user enters valid credentials")
    public void enter_the_valid_data(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }
    @Then("user is redirected to the dashboard")
    public void close_the_browser() throws InterruptedException {
        String expectUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectUrl, actualUrl);
        Thread.sleep(3000);
        driver.close();
    }
}
