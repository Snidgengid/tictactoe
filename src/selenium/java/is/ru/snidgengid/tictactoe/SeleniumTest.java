package is.ru.snidgengid.tictactoe;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:4567";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testXWon() throws Exception {
    driver.get(baseUrl + "/");
    Thread.sleep(1000);    
    driver.findElement(By.id("canvas1")).click();
    Thread.sleep(1000);    
    driver.findElement(By.id("canvas2")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("canvas5")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("canvas8")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("canvas4")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("canvas3")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("canvas6")).click();
    Thread.sleep(1000);
    for (int second = 0;; second++) {
        if (second >= 5) {
            fail("Game has not indicated that X has won");
        }
        try { if ("X has won the game!".equals(driver.findElement(By.cssSelector("div.whoWon")).getText())) break; } catch (Exception e) {}
        Thread.sleep(1000);
    }

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
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
