package ohtu;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Tester {

    public static void main(String[] args) {

        Random r = new Random();

        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);

        element.submit();

        sleep(2);

        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(2);

        element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        // Failed login case

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vääräsalasana");
        element = driver.findElement(By.name("login"));

        sleep(2);

        element.submit();

        sleep(2);

        element = driver.findElement(By.linkText("back to home"));
        element.click();

        sleep(2);

        // Registering new user

        element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        String newUserName = RandomStringUtils.randomAlphanumeric(10);

        element = driver.findElement(By.name("username"));
        element.sendKeys(newUserName);

        sleep(2);

        String newPassword = RandomStringUtils.randomAlphanumeric(10);

        element = driver.findElement(By.name("password"));
        element.sendKeys(newPassword);

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys(newPassword);

        sleep(1);

        element.submit();

        // Logout new user

        sleep(2);

        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();

        sleep(2);

        element = driver.findElement(By.linkText("logout"));
        element.click();

        sleep(2);

        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
