import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest {

    WebDriver driver;

    @BeforeMethod
    public void precondition() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public void testCss() {

        WebElement table = driver.findElement(By.id("customers"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("Amount of table rows: " + rows.size());

        WebElement headerRow = rows.get(0);
        List<WebElement> headerColumns = headerRow.findElements(By.tagName("th"));
        System.out.println("Amount of table columns: " + headerColumns.size());

        WebElement row3 = rows.get(2);
        String row3Locator = "tr:nth-child(3)";
        System.out.println("Locator for the row3: " + row3Locator);

        WebElement lastColumn = headerColumns.get(headerColumns.size() - 1);
        String lastColumnLocator = "th:last-child";
        System.out.println("Locator for the last column: " + lastColumnLocator);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}