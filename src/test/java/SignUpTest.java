import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {

    @Test
    public void checkFullPositiveSignUp() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

        WebDriver browser = new ChromeDriver();
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("11111");
        browser.findElement(By.cssSelector("[value = Continue]")).click();

        browser.findElement(By.name("first_name")).sendKeys("Svetlana");
        browser.findElement(By.name("last_name")).sendKeys("Grishel");
        browser.findElement(By.name("email")).sendKeys("test_222@gmail.com");
        browser.findElement(By.name("password1")).sendKeys("12345678");
        browser.findElement(By.name("password2")).sendKeys("12345678");
        browser.findElement(By.cssSelector("[value = Register]")).click();

        String signUpMessage = browser.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(signUpMessage, "Account is created!");

        browser.quit();
    }
}
