import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StartTest {

    WebDriver driver;

    @BeforeMethod
    public void precondition() {

        driver = new ChromeDriver();
        driver.navigate().to("https://www.leumi.co.il/");
    }

    @Test
    public void testPrint() {

        WebElement element = driver.findElement(By.xpath("//span[contains(text(), 'פרטי')]"));

        if (element != null) {
            System.out.println(element.getText());
        } else {
            System.out.println("Element not found");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}