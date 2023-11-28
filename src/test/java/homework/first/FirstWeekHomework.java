package homework.first;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstWeekHomework {

    @Test
    public void successfulLoginTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement usernameFieldID = driver.findElement(By.id("user-name"));
        usernameFieldID.sendKeys("standard_user");

        WebElement passwordFieldID = driver.findElement(By.id("password"));
        passwordFieldID.sendKeys("secret_sauce");

        WebElement loginButtonID = driver.findElement(By.id("login-button"));
        loginButtonID.click();

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.saucedemo.com/inventory.html");

        driver.quit();
    }

    @Test
    public void unsuccessfulLoginTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement usernameFieldID = driver.findElement(By.id("user-name"));
        usernameFieldID.sendKeys("wrong_username");

        WebElement passwordFieldID = driver.findElement(By.id("password"));
        passwordFieldID.sendKeys("wrong_password");

        WebElement loginButtonID = driver.findElement(By.id("login-button"));
        loginButtonID.click();

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.saucedemo.com/inventory.html");

        driver.quit();
    }
}
