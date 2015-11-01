package is.ru.snidgengid.tictactoe;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class SeleniumTest {

    static WebDriver driver;
    static String baseUrl;
    static String port;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass
    public static void before() {
        driver = new FirefoxDriver();
        port = System.getenv("PORT");
        if (port == null) {
            port = "4567";
        }
        baseUrl = "http://localhost:" + port;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void after() {
        driver.close();
    }

    @Before
    public void setup() {
        ;
    }


    @Test
    public void test() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("canvas1")).click();
        driver.findElement(By.id("canvas2")).click();
        driver.findElement(By.id("canvas4")).click();
        driver.findElement(By.id("newGame")).click();
        try {
            assertEquals("", driver.findElement(By.id("newGame")).getAttribute("id=newGame"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testXwon() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.id("canvas1")).click();
        driver.findElement(By.id("canvas2")).click();
        driver.findElement(By.id("canvas3")).click();
        driver.findElement(By.id("canvas6")).click();
        driver.findElement(By.id("canvas5")).click();
        driver.findElement(By.id("canvas4")).click();
        driver.findElement(By.id("canvas8")).click();
        driver.findElement(By.id("canvas9")).click();
        driver.findElement(By.id("canvas7")).click();
        assertEquals("X has won the game!", closeAlertAndGetItsText());
    }

    private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

}