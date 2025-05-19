package dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProvider {
    @Test(dataProvider = "getTestData")
    public void login(String username , String password){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

    }

    @org.testng.annotations.DataProvider
    public Object[][] getTestData(){
        Object[][] data = new Object[2][2];
        data[0][0]= "standard_user";
        data[0][1] = "secret_sauce";
        data[1][0]= "problem_user";
        data[1][1] = "secret_sauce";
        return data;
    }
}
