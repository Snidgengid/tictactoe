package is.ru.snidgengid.tictactoe;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SeleniumTest {

    static WebDriver driver;
    static String baseUrl;
    static String port;
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

}