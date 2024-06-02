package Task18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Question1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
       // Verify that the website has been redirected to the Facebook homepage
        if (!driver.getTitle().contains("Facebook")) {
            System.out.println("Not redirected to Facebook homepage");
            return;
        }
        driver.manage().window().maximize();
        WebElement createAccount =driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createAccount.click();
        Thread.sleep(2000);
        //name
        driver.findElement(By.name("firstname")).sendKeys("Test");
        driver.findElement(By.name("lastname")).sendKeys("User");

        //email and password
        driver.findElement(By.name("reg_email__")).sendKeys("testuser@gmail.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("testuser@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("Strongpassword123");

        //birthday
        driver.findElement(By.name("birthday_day")).sendKeys("11");
        driver.findElement(By.name("birthday_month")).sendKeys("May");
        driver.findElement(By.name("birthday_year")).sendKeys("1985");

        //gender
        driver.findElement(By.xpath("//input[@value='1']")).click();

        //signup
        driver.findElement(By.name("websubmit")).click();

        //Verify user registration
        // Note: Facebook might require a captcha or additional verification
        // step here so we might not be able to automate this completely
        Thread.sleep(5000);
        if (driver.getCurrentUrl().contains("facebook.com")) {
            System.out.println("Successfully registered and redirected to Facebook homepage");
        } else {
            System.out.println("Registration failed or additional verification required");
        }
        }
    }

