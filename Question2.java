package Task18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Question2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions a = new Actions(driver);
        a.dragAndDrop(source,target).perform();

        String targetText = target.getText();
        String targetClass = target.getAttribute("class");

        if (targetText.equals("Dropped!") && targetClass.contains("ui-state-highlight")) {
            System.out.println("Drag and drop operation successful");
        } else {
            System.out.println("Drag and drop operation failed");
        }





    }
}
