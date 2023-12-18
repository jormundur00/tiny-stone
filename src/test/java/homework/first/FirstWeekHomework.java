package homework.first;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FirstWeekHomework {

    WebDriver driver = null;

    @Test
    public void successfulLoginTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement usernameFieldID = driver.findElement(By.id("user-name"));
        usernameFieldID.sendKeys("standard_user");

        WebElement passwordFieldID = driver.findElement(By.id("password"));
        passwordFieldID.sendKeys("secret_sauce");

        WebElement loginButtonID = driver.findElement(By.id("login-button"));
        loginButtonID.click();

        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void unsuccessfulLoginTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement usernameFieldID = driver.findElement(By.id("user-name"));
        usernameFieldID.sendKeys("wrong_username");

        WebElement passwordFieldID = driver.findElement(By.id("password"));
        passwordFieldID.sendKeys("wrong_password");

        WebElement loginButtonID = driver.findElement(By.id("login-button"));
        loginButtonID.click();

        WebElement errorFieldID = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertEquals(errorFieldID.getText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
